package com.balancedpayments;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

import java.util.Map;

public class Callback extends Resource {

    public static final String resource_href = "/callbacks";

    @ResourceField(mutable=true)
    public String url;

    @ResourceField(mutable=true, required=false)
    public String method;

    @ResourceField(mutable=true, required=false)
    public String revision;

    public static class Collection extends ResourceCollection<Callback> {
        public Collection(String href) {
            super(Callback.class, href);
        }
    };

    public Callback() {
        super();
    }

    public Callback(String href) throws HTTPError {
        super(href);
    }

    public Callback(Map<String, Object> payload) throws HTTPError {
        super(payload);
    }

    public static ResourceQuery<Callback> query() {
        return new ResourceQuery<Callback>(Callback.class, resource_href);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null) {
            href = resource_href;
        }
        super.save();
    }
}
