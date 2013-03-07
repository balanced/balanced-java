package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class BankAccountVerification extends Resource {

    public Integer attempts;
    public Integer remaining_attempts;
    public String state;
    
    public static class Collection extends ResourceCollection<BankAccountVerification> {
        public Collection(String uri) {
            super(BankAccountVerification.class, uri);
        }
    };
    
    public BankAccountVerification() {
        super();
    }
    
    public BankAccountVerification(String uri) throws HTTPError {
        super(uri);
    }
    
    public BankAccountVerification(Map<String, Object> payload) {
        super(payload);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("attempts", attempts);
        payload.put("remaining_attempts", remaining_attempts);
        payload.put("state", state);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        attempts = ((Double) payload.get("attempts")).intValue();
        remaining_attempts = ((Double) payload.get("remaining_attempts")).intValue();
        state = (String) payload.get("state");
    }

    public void confirm(int amount_1, int amount_2) throws HTTPError {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("amount_1", amount_1);
        request.put("amount_2", amount_2);
        Map<String, Object> response = client.put(uri, request);
        deserialize(response);
    }
}
