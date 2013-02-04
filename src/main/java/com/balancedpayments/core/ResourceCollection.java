package com.balancedpayments.core;

import java.net.URISyntaxException;

public class ResourceCollection<T> extends ResourcePagination<T> {
    
    public ResourceCollection(Class<T> cls, String uri) {
        super(cls, uri);
    }
    
    public ResourceQuery<T> query() {
        try {
            return new ResourceQuery<T>(cls, uri_builder.build().toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
