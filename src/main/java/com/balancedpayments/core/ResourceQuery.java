package com.balancedpayments.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class ResourceQuery<T> extends ResourcePagination<T> {

    protected static final ThreadLocal<SimpleDateFormat> dateTimeFormat
            = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        }
    };

    public ResourceQuery(Class<T> cls, String uri) {
        super(cls, uri);
    }

    public T first() throws HTTPError {
        Integer limit = getLimit();
        setLimit(1);
        ArrayList<T> items = all();
        setLimit(limit);
        if (items.size() == 0)
            return null;
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

    // filtering

    public ResourceQuery<T> filter(String field, String op, String value) {
        String name = String.format("%s[%s]", field, op);
        uri_builder.addParameter(name, value);
        return this;
    }

    public ResourceQuery<T> filter(String field, String op, String[] values) {
        String name = String.format("%s[%s]", field, op);
        String value = StringUtils.join(",", values);
        uri_builder.addParameter(name, value);
        return this;
    }

    public ResourceQuery<T> filter(String field, String value) {
        uri_builder.addParameter(field, value);
        return this;
    }

    public ResourceQuery<T> filter(String field, String[] values) {
        String value = StringUtils.join(",", values);
        uri_builder.addParameter(field, value);
        return this;
    }

    public ResourceQuery<T> filter(String field, String op, Date value) {
        return this.filter(field, op, dateTimeFormat.get().format(value));
    }

    public ResourceQuery<T> filter(String field, String op, Date[] values) {
        String[] transformed = new String[values.length];
        for (int i = 0; i != values.length; i++)
            transformed[i] = dateTimeFormat.get().format(values[i]);
        return this.filter(field, op, transformed);
    }

    public ResourceQuery<T> filter(String field, Date value) {
        return this.filter(field, dateTimeFormat.get().format(value));
    }

    public ResourceQuery<T> filter(String field, Date[] values) {
        String[] transformed = new String[values.length];
        for (int i = 0; i != values.length; i++)
            transformed[i] = dateTimeFormat.get().format(values[i]);
        return this.filter(field, transformed);
    }

    public ResourceQuery<T> filter(String field, String op, Object value) {
        return this.filter(field, op, String.valueOf(value));
    }

    public ResourceQuery<T> filter(String field, String op, Object[] values) {
        String[] transformed = new String[values.length];
        for (int i = 0; i != values.length; i++)
            transformed[i] = String.valueOf(values[i]);
        return this.filter(field, op, transformed);
    }

    public ResourceQuery<T> filter(String field, Object value) {
        return this.filter(field, String.valueOf(value));
    }

    public ResourceQuery<T> filter(String field, Object[] values) {
        String[] transformed = new String[values.length];
        for (int i = 0; i != values.length; i++)
            transformed[i] = String.valueOf(values[i]);
        return this.filter(field, transformed);
    }

    // sorting

    public ResourceQuery<T> order_by(String field) {
        uri_builder.addParameter("sort", field);
        return this;
    }

    public ResourceQuery<T> order_by(String field, boolean ascending) {
        String value = String.format("%s,%s", field, ascending ? "asc" : "desc");
        uri_builder.addParameter("sort", value);
        return this;
    }
}
