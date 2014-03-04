package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class ApiKey extends Resource
{
    private static final String resource_href = "/api_keys";

    @ResourceField(required=false)
    public String secret;

    public static ResourceCollection<ApiKey> query() {
        return new ResourceCollection<ApiKey>(ApiKey.class, resource_href);
    }

    public void saveToExistingMarketplace() throws HTTPError {
        if (id == null && href == null)
            href = ApiKey.resource_href;
        super.save();
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        Balanced.configure(null);
        super.save();
    }
}
