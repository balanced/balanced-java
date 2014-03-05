package com.balancedpayments.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.balancedpayments.Balanced;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public abstract class Resource {

    protected static final ThreadLocal<SimpleDateFormat> dateTimeFormat
            = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        }
    };

    @ResourceField()
    public Date created_at;

    @ResourceField()
    public String href;

    public Map<String, String> hyperlinks;

    @ResourceField()
    public String id;

    @ResourceField(mutable=true)
    public Map<String, Object> links;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField()
    public Date updated_at;


    public Resource() {
    }

    public Resource(Map<String, Object> payload) throws HTTPError {
        this.constructFromResponse(payload);
    }

    public Resource(String href) throws HTTPError {
        Map<String, Object> payload = Balanced.getInstance().getClient().get(href);
        this.deserialize(payload);
    }

    public void save() throws HTTPError {
        Map<String, Object> request = serialize();
        Map<String, Object> response = null;
        if (id == null) {
            if (href == null)
                throw new RuntimeException(this.getClass().getName());
            response = Balanced.getInstance().getClient().post(href, request);
        }
        else {
            response = Balanced.getInstance().getClient().put(href, request);
        }
        deserialize(response);
    }

    public void unstore() throws NotCreated, HTTPError {
        delete();
    }

    public void delete() throws NotCreated, HTTPError {
        if (id == null)
            throw new NotCreated(this.getClass());
        Balanced.getInstance().getClient().delete(href);
    }

    public void reload() throws HTTPError {
        deserialize(Balanced.getInstance().getClient().get(href));
    }

    @Deprecated
    public void refresh() throws HTTPError {
        reload();
    }

    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        Field[] fields = this.getClass().getFields();
        for(Field f : fields){
            if (!f.isAnnotationPresent(ResourceField.class)) {
                continue;
            }
            ResourceField rf = f.getAnnotation(ResourceField.class);
            if (!rf.mutable()) {
                continue;
            }
            String name = rf.field().equals("") ? f.getName() : rf.field();
            Object value;
            try {
                value = f.get(this);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            payload.put(name, value);
         }
        return payload;
    }

    public void constructFromResponse(Map<String, Object>payload) throws HTTPError{
        Field[] fields = this.getClass().getFields();
        for (Field f : fields) {
            if (!f.isAnnotationPresent(ResourceField.class)) {
                continue;
            }

            Object value = null;

            ResourceField rf = f.getAnnotation(ResourceField.class);
            String key = rf.field().equals("") ? f.getName() : rf.field();

            if (f.getName() == "source") {
                String foo = "bar";
            }

            if (key.contains(".")) {
                value = this.hyperlinks != null ? this.hyperlinks.get(key) : null;
            }
            else if (!rf.required() && !payload.containsKey(key)) {
                value = null;
            }
            else {
                value = payload.get(key);
            }

            if (f.getType() == Date.class) {
                value = deserializeDate((String) value);
            }
            else if (f.getType() == String[].class) {
                value = (((ArrayList<String>) value).toArray(new String[0]));
            }
            else if (f.getType() == Integer.class) {
                try {
                    value = ((Double) value).intValue();
                } catch (Exception e) {
                    value = value;
                }
            }
            else if (Resource.class.isAssignableFrom(f.getType())) {
                if (value != null) {
                    if (value instanceof String) {
                        value = Balanced.getInstance().getClient().get((String)value);
                    }
                    value = deserializeResource((Map<String, Object>)value, f.getType());
                }
            }
            else if (ResourceCollection.class.isAssignableFrom(f.getType())) {
                if (value != null) {
                    value = deserializeResourceCollection((String) value, f.getType());
                }
            }

            try {
                f.set(this, value);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void hydrate(Map<String, String> links, Map<String, String> meta, Map<String, Object> entity) {
        for (Map.Entry<String, String> link : links.entrySet()) {
            String key = link.getKey();
            String value = link.getValue();
            String expandedValue = null;
            if (value != null) {
                Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
                Matcher matcher = logEntry.matcher(value);
                if (matcher.find()) {
                    String token = matcher.group(1);
                    String[]linkKey = token.split("\\.");
                    String linkVal = (String)entity.get(linkKey[1]);

                    // hack for "self" in events.callbacks link
                    if (linkKey[1].equals("self")) {
                        linkKey[1] = "id";
                    }

                    if (linkVal != null) {
                        expandedValue = value.replaceAll("\\{" + token + "\\}", linkVal);
                    }
                    else {
                        linkVal = ((Map<String, String>)entity.get("links")).get(linkKey[1]);
                        if (linkVal != null) {
                            expandedValue = value.replaceAll("\\{" + token + "\\}", linkVal);
                        }
                    }
                }
                else {
                    expandedValue = value;
                }
            }

            link.setValue(expandedValue);
        }
        this.hyperlinks = links;
    }

    public void deserialize(Map<String, Object> payload) throws HTTPError{
        Map<String, String> links = (Map<String, String>)payload.remove("links");
        Map<String, String> meta = (Map<String, String>)payload.remove("meta");

        if (payload.size() > 1) {
            throw new RuntimeException("Not supported yet");
        }

        for (Object key : payload.keySet()) {
            Map<String, Object> entity = (Map<String, Object>)((ArrayList)payload.get(key)).get(0);
            hydrate(links, meta, entity);
            constructFromResponse(entity);
        }
    }

    protected Date deserializeDate(String raw) {
        // http://stackoverflow.com/a/2132605/1339571
        if (raw == null) return null;
        raw = raw.substring(0, 23) + raw.substring(26, raw.length());
        try {
            return dateTimeFormat.get().parse(raw);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    protected Object deserializeResourceCollection(String raw, Class clazz) {
        Object value;

        Constructor<?> ctor;
        try {
            ctor = clazz.getConstructor(String.class);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            value = ctor.newInstance(new Object[] { raw });
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return value;
    }

    protected Resource deserializeResource(Map<String, Object> raw, Class clazz) throws HTTPError {
        Resource value;

        Constructor<?> ctor;
        try {
            ctor = clazz.getConstructor();
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            value = (Resource) ctor.newInstance(new Object[] { });
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        value.deserialize(raw);

        return value;
    }
}

