package com.balanced.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.balanced.Settings;
import com.balanced.errors.CannotCreate;
import com.balanced.errors.HTTPError;
import com.balanced.errors.NotCreated;

public abstract class Resource {
    
    protected static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    protected Client client = new Client();
    
    public String uri;
    public String id;

    public Resource() {
    }
    
    public Resource(Map<String, Object> payload) {
        this.deserialize(payload);
    }
    
    public void save() throws HTTPError {
        Map<String, Object> request = serialize();
        Map<String, Object> response = null;
        if (id == null) {
            if (uri == null)
                throw new RuntimeException(this.getClass().getName());
            response = client.post(uri, request);
        }
        else
            response = client.put(uri, request);
        deserialize(response);
    }
    
    public void delete() throws NotCreated, HTTPError {
        if (id == null)
            throw new NotCreated(this.getClass());
        client.delete(uri);
    }
    
    public abstract Map<String, Object> serialize();
    
    public void deserialize(Map<String, Object> payload) {
        uri = (String) payload.get("uri");
        id = (String) payload.get("id");
    }
    
    protected Date deserializeDate(String raw) {
        // http://stackoverflow.com/a/2132605/1339571
        raw = raw.substring(0, 23) + raw.substring(26, raw.length());
        try {
            return dateTimeFormat.parse(raw);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
