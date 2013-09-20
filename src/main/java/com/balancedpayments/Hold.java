package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Hold extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField()
    public Date expires_at;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

    @ResourceField()
    public Debit debit;

    @ResourceField(mutable=true)
    public String transaction_number;

    @ResourceField(mutable=true)
    public Boolean is_void;

    @ResourceField(required=false)
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public String customer_uri;

    @ResourceField(required=false)
    public Customer customer;

    @ResourceField(required=false)
    public String card_uri;

    @ResourceField(required=false)
    public Card card;

    @ResourceField(required=false)
    public FundingInstrument source;

    public static class Collection extends ResourceCollection<Hold> {
        public Collection(String uri) {
            super(Hold.class, uri);
        }
    };

    public static Hold get(String uri) throws HTTPError {
        return new Hold((new Client()).get(uri));
    }

    public Hold() {
        super();
    }

    public Hold(String uri) throws HTTPError {
        super(uri);
    }

    public Hold(Map<String, Object> payload) {
        super(payload);
    }

    public Account getAccount() throws HTTPError {
        if (account == null)
            account = new Account(account_uri);
        return account;
    }

    public Card getCard() throws HTTPError {
        if (card == null)
            card = new Card(card_uri);
        return card;
    }

    public void void_() throws HTTPError {
        is_void = true;
        save();
    }

    public Debit capture(int amount) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("hold_uri", uri);
        payload.put("amount", amount);
        if (appears_on_statement_as != null) {
            payload.put("appears_on_statement_as", appears_on_statement_as);
        }
        if (description != null) {
            payload.put("description", description);
        }
        Debit.Collection debits;
        if (customer != null) {
            debits = customer.debits;
        } else if (account != null) {
            debits = account.debits;
        } else {
            throw new IllegalStateException("Can't capture without either a Customer or Account having been established");
        }
        debit = debits.create(payload);
        return debit;
    }

    public Debit capture() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("hold_uri", uri);
        if (appears_on_statement_as != null) {
            payload.put("appears_on_statement_as", appears_on_statement_as);
        }
        if (description != null) {
            payload.put("description", description);
        }
        Debit.Collection debits;
        if (customer != null) {
            debits = customer.debits;
        } else if (account != null) {
            debits = account.debits;
        } else {
            throw new IllegalStateException("Can't capture without either a Customer or Account having been established");
        }
        debit = debits.create(payload);
        return debit;
    }
}
