package com.balancedpayments;

import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Callback extends Resource {

    @ResourceField(mutable=true)
    public String url;

    @ResourceField(mutable=true, required=false)
    public String method;

    public static class Collection extends ResourceCollection<Callback> {
        public Collection(String uri) {
            super(Callback.class, uri);
        }

        public Callback create(String url, String method) throws HTTPError {
            Callback callback = new Callback();
            callback.uri = getURI();
            callback.url = url;
            if (method != null) {
                callback.method = method;
            }
            callback.save();
            return callback;
        }

        public Callback create(String url) throws HTTPError {
            return create(url, null);
        }
    };

    public Callback() {
        super();
    }

    public Callback(String uri) throws HTTPError {
        super(uri);
    }
}
