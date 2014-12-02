package com.balancedpayments;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

import java.util.Map;

public class Settlement extends Resource {

    public static final String resource_href = "/settlements";

    // fields

    @ResourceField(mutable=true)
    public String funding_instrument;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

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

    @ResourceField(field="settlements.destination")
    public FundingInstrument destination;

    @ResourceField(field="settlements.source")
    public FundingInstrument source;

    public static class Collection extends ResourceCollection<Settlement> {
        public Collection(String uri) {
            super(Settlement.class, uri);
        }
    }

    public static Settlement get(String uri) throws HTTPError {
        return new Settlement((Balanced.getInstance().getClient()).get(uri));
    }

    public Settlement() {
        super();
    }

    public Settlement(String uri) throws HTTPError {
        super(uri);
    }

    public Settlement(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }
}
