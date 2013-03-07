package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class Callback extends Resource {
    
    public String url; 
    
    public static class Collection extends ResourceCollection<Callback> {
        public Collection(String uri) {
            super(Callback.class, uri);
        }
        
        public Callback create(String url) throws HTTPError {
            Callback callback = new Callback();
            callback.uri = getURI();
            callback.url = url;
            callback.save();
            return callback;
        }
    };

    public Callback() {
        super();
    }
    
    public Callback(String uri) throws HTTPError {
        super(uri);
    }
    
    public Callback(Map<String, Object> payload) {
        super(payload);
    }
    
    @Override    
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("url", url);
        return payload;
    }
    
    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        url = (String) payload.get("url");
    }
}
