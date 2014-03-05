package com.balancedpayments.errors;

import java.util.Map;

import org.apache.http.HttpResponse;

public class APIError extends HTTPError {
    public String category_type;
    public String category_code;
    public String description;
    public Map<String, Object> extras;
    public String request_id;
    public String status;
    public Integer status_code;
    
    public APIError(
            HttpResponse response,
            String raw,
            Map<String, Object> payload) {
        super(response, raw);
        this.category_type = (String) payload.get("category_type");
        this.category_code = (String) payload.get("category_code");
        this.description = (String) payload.get("description");
        this.extras = (Map<String, Object>) payload.get("extras");
        this.request_id = (String) payload.get("request_id");
        this.status = (String) payload.get("status");
        this.status_code = ((Double)payload.get("status_code")).intValue();
    }
}
