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
    public String uri;

    @ResourceField()
    public String id;

    public Resource() {
    }

    public Resource(Map<String, Object> payload) throws HTTPError {
        this.deserialize(payload);
    }

    public Resource(String uri) throws HTTPError {
        Map<String, Object> payload = Balanced.getInstance().getClient().get(uri);
        this.deserialize(payload);
    }

    public void save() throws HTTPError {
        Map<String, Object> request = serialize();
        Map<String, Object> response = null;
        if (id == null) {
            if (uri == null)
                throw new RuntimeException(this.getClass().getName());
            response = Balanced.getInstance().getClient().post(uri, request);
        }
        else {
            response = Balanced.getInstance().getClient().put(uri, request);
        }
        deserialize(response);
    }

    public void unstore() throws NotCreated, HTTPError {
        delete();
    }

    public void delete() throws NotCreated, HTTPError {
        if (id == null)
            throw new NotCreated(this.getClass());
        Balanced.getInstance().getClient().delete(uri);
    }

    public void reload() throws HTTPError {
        deserialize(Balanced.getInstance().getClient().get(uri));
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

    public void deserialize(Map<String, Object> payload) throws HTTPError{
        Field[] fields = this.getClass().getFields();
        for(Field f : fields){
            if (!f.isAnnotationPresent(ResourceField.class)) {
                continue;
            }

            Object value = null;

            ResourceField rf = f.getAnnotation(ResourceField.class);
            String key = rf.field().equals("") ? f.getName() : rf.field();
            if (!rf.required() && !payload.containsKey(key)) {
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

