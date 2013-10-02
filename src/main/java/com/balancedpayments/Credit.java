package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Credit extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true, required=false)
    public String appears_on_statement_as;

    @ResourceField()
    public String description;

    @ResourceField()
    public String status;

    @ResourceField(mutable=true, required=false)
    public Map<String, String> bank_account;

    @ResourceField(mutable=true, required=false)
    public String destination_uri;

    @ResourceField()
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public Customer customer;

    @ResourceField(field="reversals_uri")
    public Reversal.Collection reversals;

    public static Credit get(String uri) throws HTTPError {
        return new Credit((Balanced.getInstance().getClient()).get(uri));
    }

    public Credit() {
        super();
    }

    public Credit(String uri) throws HTTPError {
        super(uri);
    }

    public Credit(Map<String, Object> payload) {
        super(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Balanced.getInstance().getAPIVersion(), "credits");
        super.save();
    }

    public Reversal reverse(Map<String, Object> payload) throws HTTPError {
        return reversals.create(payload);
    }

    public Reversal reverse() throws HTTPError {
        return reverse(null);
    }

    public static class Collection extends ResourceCollection<Credit> {
        public Collection(String uri) {
            super(Credit.class, uri);
        }
    }
}
