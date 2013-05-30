package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

public class Refund extends Resource {

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
    public Debit debit;


    public static class Collection extends ResourceCollection<Refund> {
        public Collection(String uri) {
            super(Refund.class, uri);
        }
    };

    public Refund() {
        super();
    }

    public Refund(Map<String, Object> payload) {
        super(payload);
    }
}
