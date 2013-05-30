package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class APIKey extends Resource
{
    private static final String root_uri = String.format("/v%s/%s", Settings.VERSION, "api_keys");

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(required=false)
    public String secret;

    public static ResourceCollection<APIKey> query() {
        return new ResourceCollection<APIKey>(APIKey.class, root_uri);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = APIKey.root_uri;
        super.save();
    }
}
