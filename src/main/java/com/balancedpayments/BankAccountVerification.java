package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class BankAccountVerification extends Resource {

    @ResourceField()
    public Integer attempts;

    @ResourceField()
    public Integer remaining_attempts;

    @ResourceField()
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

    public void confirm(int amount_1, int amount_2) throws HTTPError {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("amount_1", amount_1);
        request.put("amount_2", amount_2);
        Map<String, Object> response = client.put(uri, request);
        deserialize(response);
    }
}
