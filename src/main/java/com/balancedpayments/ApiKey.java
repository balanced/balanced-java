package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class ApiKey extends Resource
{
    public static final String resource_href = "/api_keys";

    @ResourceField(required=false)
    public String secret;


    public static class Collection extends ResourceCollection<ApiKey> {
        public Collection(String uri) {
            super(ApiKey.class, uri);
        }
    }

    public static ResourceCollection<ApiKey> query() {
        return new ResourceCollection<ApiKey>(ApiKey.class, resource_href);
    }

    public void saveToExistingMarketplace() throws HTTPError {
        if (id == null && href == null)
            href = ApiKey.resource_href;
        super.save();
    }

    public ApiKey() throws HTTPError {
        super();
    }

    public ApiKey(String uri) throws HTTPError {
        super(uri);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        Balanced.configure(null);
        super.save();
    }
}
