package com.balancedpayments.errors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;

public class Declined extends APIError {
    
    public static final List<String> CODES = Arrays.asList(
            "funding-destination-declined",
            "authorization-failed");

    public Declined(
            HttpResponse response,
            String raw,
            Map<String, Object> parsed) {
        super(response, raw, parsed);
    }
    
}
