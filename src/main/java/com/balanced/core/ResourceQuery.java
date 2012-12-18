package com.balanced.core;

import java.util.ArrayList;

import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class ResourceQuery<T> extends ResourceCollection<T> {

    public ResourceQuery(Class<T> cls, String uri) {
        super(cls, uri);
    }

    public T first() throws NoResultsFound, HTTPError {
        Integer limit = getLimit();
        setLimit(1);
        ArrayList<T> items = all();
        setLimit(limit);
        if (items.size() == 0)
            throw new NoResultsFound();
        return items.get(0);
    }
    
    public T one() throws NoResultsFound, MultipleResultsFound, HTTPError {
        Integer limit = getLimit();
        setLimit(2);
        ArrayList<T> items = all();
        setLimit(limit);
        if (items.size() == 0)
            throw new NoResultsFound();
        if (items.size() > 1)
            throw new MultipleResultsFound();
        return items.get(0);
    }
}
