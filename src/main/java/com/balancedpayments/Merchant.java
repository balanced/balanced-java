package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class Merchant extends Resource {

    public static final String PERSON_TYPE = "person";
    public static final String BUSINESS_TYPE = "business";

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public String type;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String email_address;

    @ResourceField(mutable=true)
    public String phone_number;

    @ResourceField()
    public String accounts_uri;

    @ResourceField()
    public ResourceCollection<Account> accounts;

    @ResourceField()
    public String api_keys_uri;

    @ResourceField()
    public ResourceCollection<APIKey> api_keys;

    @ResourceField(mutable=true)
    public String street_address;

    @ResourceField(mutable=true)
    public String city;

    @ResourceField(mutable=true)
    public String postal_code;

    @ResourceField(mutable=true)
    public String country_code;

    @ResourceField(mutable=true)
    public String dob;

    @ResourceField(mutable=true)
    public Map<String, String> meta;


    public static ResourceQuery<Merchant> query() {
        return new ResourceQuery<Merchant>(
                Merchant.class,
                String.format("/v%s/%s", Balanced.getInstance().getAPIVersion(), "merchants"));
    }

    public static Merchant me() throws NoResultsFound, MultipleResultsFound, HTTPError {
        return query().one();
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Balanced.getInstance().getAPIVersion(), ",merchants");
        super.save();
    }
}
