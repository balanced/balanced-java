package com.balanced.errors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;

public class InsufficientFunds extends APIError {
    
    public static final List<String> CODES = Arrays.asList("insufficient-funds");

    public InsufficientFunds(
            HttpResponse response,
            String raw,
            Map<String, Object> parsed) {
        super(response, raw, parsed);
    }

}
