package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Reversal extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(required=false)
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

    @ResourceField()
    public String transaction_number;

    @ResourceField()
    public Credit credit;


    public static class Collection extends ResourceCollection<Reversal> {
        public Collection(String uri) {
            super(Reversal.class, uri);
        }
    }

    public static Reversal get(String uri) throws HTTPError {
        return new Reversal((Balanced.getInstance().getClient()).get(uri));
    }

    public Reversal() {
        super();
    }

    public Reversal(Object obj) throws HTTPError {
        super(obj);
    }
}
