package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Debit extends Resource  {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(mutable=true)
    public String transaction_number;

    @ResourceField(required=false)
    public String card_uri;

    @ResourceField(required=false)
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public String source_uri;

    @ResourceField(required=false)
    public FundingInstrument source;

    @ResourceField(required=false)
    public String customer_uri;

    @ResourceField(required=false)
    public Customer customer;

    @ResourceField(required=false)
    public String appears_on_statement_as;

    @ResourceField(required=false)
    public String hold_uri;

    @ResourceField(required=false)
    public Hold hold;

    @ResourceField(field="refunds_uri")
    public Refund.Collection refunds;

    public static class Collection extends ResourceCollection<Debit> {
        public Collection(String uri) {
            super(Debit.class, uri);
        }
    };

    public Debit() {
        super();
    }

    public Debit(String uri) throws HTTPError {
        super(uri);
    }

    public Debit(Map<String, Object> payload) {
        super(payload);
    }

    public Refund refund(Map<String, Object> payload) throws HTTPError {
        return refunds.create(payload);
    }

    public Refund refund() throws HTTPError {
        return refund(null);
    }

    public Account getAccount() throws HTTPError {
        if (account == null)
            account = new Account(account_uri);
        return account;
    }

    public Customer getCustomer() throws HTTPError {
        if (customer == null)
            customer = customer_uri == null ? null : new Customer(customer_uri);
        return customer;
    }

    public FundingInstrument getSource() throws HTTPError {
        if (source == null)
            source = source_uri == null ? null : new FundingInstrument(source_uri);
        return source;
    }

    public Hold getHold() throws HTTPError {
        if (hold == null)
            hold = new Hold(hold_uri);
        return hold;
    }
}
