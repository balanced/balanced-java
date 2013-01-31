package com.balancedpayments.errors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;

public class DuplicateAccountEmailAddress extends APIError {

    public static final List<String> CODES = Arrays.asList("duplicate-email-address");
    
    public String account_uri;

    public DuplicateAccountEmailAddress(
            HttpResponse response,
            String raw,
            Map<String, Object> parsed) {
        super(response, raw, parsed);
        this.account_uri = (String) this.extras.get("uri");
    }

}
