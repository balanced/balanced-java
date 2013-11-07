package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Event extends Resource {

    @ResourceField()
    public Date occurred_at;

    @ResourceField()
    public String type;

    @ResourceField()
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

    public Event(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    @Override
    public Map<String, Object> serialize() {
        throw new RuntimeException("Cannot be created or updated");
    }
}
