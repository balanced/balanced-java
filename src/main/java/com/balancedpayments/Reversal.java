package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Reversal extends Resource {

    // fields

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String description;

    // attributes

    @ResourceField()
    public String currency;

    @ResourceField()
    public String failure_reason;

    @ResourceField()
    public String failure_reason_code;

    @ResourceField()
    public String status;

    @ResourceField()
    public String transaction_number;

    @ResourceField(field="reversals.credit")
    public Credit credit;

    @ResourceField(field="reversals.events")
    public Event.Collection events;

    //@ResourceField(field="reversals.order")
    //public Order order;


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
    public Reversal(String uri) throws HTTPError {
        super(uri);
    }

    public Reversal(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }
}
