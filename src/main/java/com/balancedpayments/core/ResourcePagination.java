package com.balancedpayments.core;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;

import com.balancedpayments.errors.HTTPError;

public class ResourcePagination<T> implements Iterable<T> {
    
    public class ResourceIterator implements Iterator<T> {
        
        public String uri;
        public ResourcePage<T> page;
        public Integer index;
        
        public ResourceIterator(String uri, ResourcePage<T> page) {
            this.uri = uri; 
            this.page = page;
            this.index = 0;
        }
        
        public boolean hasNext() {
            try {
                return (index < page.getSize() || this.page.getNextUri() != null);
            }
            catch (HTTPError e) {
                throw new RuntimeException(e);
            }
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            try {
                if (index >= page.getSize()) {
                    page = page.getNext();
                    index = 0; 
                }
                T t = page.getItems().get(index);
                index += 1;
                return t;
            }
            catch (HTTPError e) {
                throw new RuntimeException(e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    protected Client client = new Client();
    protected Class<T> cls;
    protected URIBuilder uri_builder; 

    public ResourcePagination(Class<T> cls, String uri) {
        this.cls = cls; 
        try {
            this.uri_builder = new URIBuilder(uri);
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
    public T create() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        return create(payload);
    }
    
    public T create(Map<String, Object> payload) throws HTTPError {
        T t;
        try {
            t = cls.newInstance();
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ((Resource) t).deserialize(client.post(getURI(), payload));
        return t;
    }
    
    public int total() throws HTTPError {
        Integer limit = getLimit();
        setLimit(1);
        String uri = getURI();
        ResourcePage<T> page = new ResourcePage<T>(cls, uri);
        setLimit(limit);
        return page.getTotal();
    }
    
    protected Integer getLimit() {
        for (NameValuePair kv: uri_builder.getQueryParams()) {
            if (kv.getName().equals("limit")) {
                return new Integer(kv.getValue());
            }
        }
        return null;
    }
    
    protected void setLimit(Integer limit) {
        if (limit == null) {
            List<NameValuePair> params = uri_builder.getQueryParams();
            NameValuePair current = null;
            Iterator<NameValuePair> iter = params.iterator();
            while (iter.hasNext()) {
                current = iter.next();
                if (current.getName().equals("limit")) {
                    iter.remove();
                    String qs = URLEncodedUtils.format(params, "UTF-8");
                    uri_builder.setQuery(qs);
                    break;
                }
            }
        }
        else
            uri_builder.setParameter("limit", limit.toString());
    }
    
    protected String getURI() {
        try {
            return uri_builder.build().toString();
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Iterator<T> iterator() {
        String uri = getURI();
        ResourcePage<T> page = new ResourcePage<T>(cls, uri);
        return new ResourceIterator(uri, page);
    }
    
    public ArrayList<T> all() throws HTTPError {
        String uri = getURI();
        ResourcePage<T> page = new ResourcePage<T>(cls, uri);
        ArrayList<T> items = new ArrayList<T>(page.getTotal());
        Iterator<T> iterator = new ResourceIterator(uri, page);
        while (iterator.hasNext()) {
            T obj = iterator.next();
            items.add(obj);
        }
        return items;
    }
}
