package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public Card card;

    @ResourceField(required=false)
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public String customer_uri;

    @ResourceField(required=false)
    public Customer customer;

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

    public Debit(Map<String, Object> payload) {
        super(payload);
    }

    public Refund refund(
            Integer amount,
            String description,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        if (amount != null)
            payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (meta != null)
            payload.put("meta", meta);
        return refunds.create(payload);
    }

    public Refund refund(int amount) throws HTTPError {
        return refund(amount, null, null);
    }

    public Refund refund() throws HTTPError {
        return refund(null, null, null);
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

    public Hold getHold() throws HTTPError {
        if (hold == null)
            hold = new Hold(hold_uri);
        return hold;
    }
}
