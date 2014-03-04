package com.balancedpayments;

import java.util.Date;
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
    public Integer attempts_remaining;

    @ResourceField()
    public String deposit_status;

    @ResourceField()
    public String verification_status;

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

    public void confirm(int amount_1, int amount_2) throws HTTPError {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("amount_1", amount_1);
        request.put("amount_2", amount_2);
        Map<String, Object> response = Balanced.getInstance().getClient().put(href, request);
        deserialize(response);
    }
}
