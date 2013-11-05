package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class FundingInstrument extends Resource {

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
        return new FundingInstrument((Balanced.getInstance().getClient()).get(uri));
    }

    public FundingInstrument() {
        super();
    }

    public FundingInstrument(Object obj) throws HTTPError{
        super(obj);
    }

    public void invalidate() throws HTTPError, NotCreated {
        unstore();
    }

    public void unstore() throws HTTPError, NotCreated {
        super.delete();
    }

    public Customer getCustomer() throws HTTPError {
        if (customer == null)
            customer = customer_uri == null ? null : new Customer(customer_uri);
        return customer;
    }
}
