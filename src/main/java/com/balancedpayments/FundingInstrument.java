package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class FundingInstrument extends Resource {

    public static class Collection extends ResourceCollection<FundingInstrument> {
        public Collection(String uri) {
            super(FundingInstrument.class, uri);
        }
    };

    public FundingInstrument() {
        super();
    }

    public FundingInstrument(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public FundingInstrument(String uri) throws HTTPError {
        super(uri);
    }

    public void unstore() throws HTTPError, NotCreated {
        super.delete();
    }

    public void associateToCustomer(Customer customer) throws HTTPError {
        this.links.put("customer", customer.href);
        this.save();
    }

    public Debit debit(Map<String, Object> payload) throws HTTPError {
        // override in subclasses
        return null;
    }
}
