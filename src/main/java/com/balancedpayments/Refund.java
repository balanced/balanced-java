package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Refund extends Resource {

    public static final String resource_href = "/refunds";

    // fields

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String description;

    // attributes

    @ResourceField()
    public String currency;

    @ResourceField()
    public String status;

    @ResourceField()
    public String transaction_number;

    @ResourceField(field="refunds.debit")
    public Debit debit;

    //@ResourceField(field="refunds.dispute")
    //public Dispute dispute;

    @ResourceField(field="refunds.events")
    public Event.Collection events;

    //@ResourceField(field="refunds.order")
    //public Order order;


    public static class Collection extends ResourceCollection<Refund> {
        public Collection(String uri) {
            super(Refund.class, uri);
        }
    };

    public Refund() {
        super();
    }
    public Refund(String uri) throws HTTPError {
        super(uri);
    }

    public Refund(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }
}
