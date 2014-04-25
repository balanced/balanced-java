package com.balancedpayments;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

import java.util.Date;


public class Dispute extends Resource {

    public static final String resource_href = "/disputes";

    @ResourceField()
    public Integer amount;

    @ResourceField()
    public String currency;

    @ResourceField()
    public Date initianted_at;

    @ResourceField()
    public String href;

    @ResourceField()
    public String reason;

    @ResourceField()
    public Date respond_by;

    @ResourceField()
    public String status;

    @ResourceField(field="disputes.events")
    public Event.Collection events;

    @ResourceField(field="disputes.transaction")
    public Debit transaction;


    public Dispute() {};

    public Dispute(String uri) throws HTTPError {
        super(uri);
    }

    public static class Collection extends ResourceCollection<Dispute> {
        public Collection(String uri) {
            super(Dispute.class, uri);
        }
    }
    public static ResourceQuery<Dispute> query() {
        return new ResourceQuery<Dispute>(Dispute.class, resource_href);
    }
}
