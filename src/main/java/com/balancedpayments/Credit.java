package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

public class Credit extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField()
    public Integer amount;

    @ResourceField()
    public String description;

    @ResourceField()
    public String status;

    @ResourceField()
    public BankAccount bank_account;

    @ResourceField()
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public Customer customer;

    public Credit() {
        super();
    }

    public Credit(String uri) {
        super();
    }

    public static class Collection extends ResourceCollection<Credit> {
        public Collection(String uri) {
            super(Credit.class, uri);
        }
    };
}
