package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class Event extends Resource {

    public Date occurred_at;
    public String type;
    public Map<String, Object> entity;
    
    public static class Collection extends ResourceCollection<Event> {
        public Collection(String uri) {
            super(Event.class, uri);
        }
    };
    
    public Event() {
        super();
    }
    
    public Event(String uri) throws HTTPError {
        super(uri);
    }
    
    public Event(Map<String, Object> payload) {
        super(payload);
    }

    @Override    
    public Map<String, Object> serialize() {
        throw new RuntimeException("Cannot be created or updated");
    }
    
    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        occurred_at = deserializeDate((String) payload.get("occurred_at"));
        type = (String) payload.get("type");
        entity = (Map<String, Object>) payload.get("entity");
    }
}
