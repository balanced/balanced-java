package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class APIKey extends Resource
{
    private static final String root = "api_keys";
    
    public String secret;
    public Date created_at;
    
    public static ResourceCollection<APIKey> query() {
        return new ResourceCollection<APIKey>(
                APIKey.class,
                String.format("/v%s/%s", Settings.VERSION, root));
    }
    
    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Settings.VERSION, root);
        super.save();
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        secret = payload.containsKey("secret") ? (String) payload.get("secret") : null;
        created_at = deserializeDate((String) payload.get("created_at"));
    }
}
