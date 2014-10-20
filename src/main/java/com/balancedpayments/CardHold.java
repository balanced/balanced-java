package com.balancedpayments;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

import java.util.Date;
import java.util.Map;

public class CardHold extends Resource {

    public static final String resource_href = "/card_holds";

    // fields

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String description;

    // attributes

    @ResourceField()
    public Date created_at;

    @ResourceField()
    public String currency;

    @ResourceField()
    public Date expires_at;

    @ResourceField()
    public String failure_reason;

    @ResourceField()
    public String failure_reason_code;

    @ResourceField()
    public String status;

    @ResourceField()
    public String transaction_number;

    @ResourceField()
    public String voided_at;

    @ResourceField(field="card_holds.card")
    public Card card;

    @ResourceField(field="card_holds.debit")
    public Debit debit;

    @ResourceField(field="card_holds.debits")
    public Debit.Collection debits;

    @ResourceField(field="card_holds.events")
    public Event.Collection events;

    @ResourceField(field="card_holds.order")
    public Order.Collection order;

    public static class Collection extends ResourceCollection<CardHold> {
        public Collection(String uri) {
            super(CardHold.class, uri);
        }
    };

    public CardHold() {
        super();
    }

    public CardHold(String uri) throws HTTPError {
        super(uri);
    }

    public Debit capture(Map<String, Object> payload) throws HTTPError {
        debit = debits.create(payload);
        return debit;
    }

    public Debit capture() throws HTTPError {
        debit = debits.create();
        return debit;
    }
}
