package com.balanced.errors;

import java.util.Map;

import org.apache.http.HttpResponse;

public class APIError extends HTTPError {
    
    public String category_type;
    public String category_code;
    public String description;
    public String request_id;
    public Map<String, Object> extras;
    
    public APIError(
            HttpResponse response,
            String raw,
            Map<String, Object> parsed) {
        super(response, raw);
        this.category_type = (String) parsed.get("category_type");
        this.category_code = (String) parsed.get("category_code");
        this.description = (String) parsed.get("description");
        this.request_id = (String) parsed.get("request_id");
        this.extras = (Map<String, Object>) parsed.get("extras");
    }
}
