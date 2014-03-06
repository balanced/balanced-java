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

    public static final String resource_href = "/debits";

    // fields

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(mutable=true, field="debits.order")
    public Order order;

    // attributes

    @ResourceField(required=false)
    public String currency;

    @ResourceField()
    public String failure_reason;

    @ResourceField()
    public String failure_reason_code;

    @ResourceField()
    public String status;

    @ResourceField()
    public String transaction_number;

    @ResourceField(field="debits.customer")
    public Customer customer;

    //@ResourceField(field="debits.dispute")
    //public Dispute dispute;

    @ResourceField(field="debits.events")
    public Event.Collection events;

    @ResourceField(field="debits.refunds")
    public Refund.Collection refunds;

    @ResourceField(field="debits.source")
    public FundingInstrument source;


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

    public Debit(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }

    public Refund refund(Map<String, Object> payload) throws HTTPError {
        return refunds.create(payload);
    }

    public Refund refund() throws HTTPError {
        return refund(null);
    }
}
