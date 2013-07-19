package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class FundingInstrument  extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public String street_address;

    @Deprecated
    @ResourceField(mutable=true, required=false)
    public Boolean is_valid;

    @ResourceField(required=false)
    public String customer_uri;

    @ResourceField(required=false)
    public Customer customer;

    public static class Collection extends ResourceCollection<FundingInstrument> {
        public Collection(String uri) {
            super(FundingInstrument.class, uri);
        }
    };

    public static FundingInstrument get(String uri) throws HTTPError {
        return new FundingInstrument((new Client()).get(uri));
    }

    public FundingInstrument() {
        super();
    }

    public FundingInstrument(Map<String, Object> payload) {
        super(payload);
    }

    public FundingInstrument(String uri) throws HTTPError {
        super(uri);
    }

    public void invalidate() throws HTTPError {
        is_valid = false;
        save();
    }

    public Customer getCustomer() throws HTTPError {
        if (customer == null)
            customer = customer_uri == null ? null : new Customer(customer_uri);
        return customer;
    }
}
