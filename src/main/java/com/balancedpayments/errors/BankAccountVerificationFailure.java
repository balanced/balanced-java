package com.balancedpayments.errors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;


public class BankAccountVerificationFailure extends APIError {
    
    public static final List<String> CODES = Arrays.asList(
            "bank-account-authentication-not-pending",
            "bank-account-authentication-failed",
            "bank-account-authentication-already-exists");

    public BankAccountVerificationFailure(
            HttpResponse response,
            String raw,
            Map<String, Object> parsed) {
        super(response, raw, parsed);
    }

}
