package com.balancedpayments;

import java.util.Date;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class BankAccount extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String account_number;

    @ResourceField(mutable=true)
    public String routing_number;

    @ResourceField(mutable=true)
    public String type;

    @ResourceField()
    public String fingerprint;

    @ResourceField()
    public String bank_name;

    @ResourceField()
    public Map<String, String> meta;

    @ResourceField(field="verifications_uri")
    public BankAccountVerification.Collection verifications;

    @ResourceField()
    public String verification_uri;

    @ResourceField(required=false)
    public BankAccountVerification verification;

    protected static final String root_uri = "/v" + Settings.VERSION + "/bank_accounts";

    public static class Collection extends ResourceCollection<BankAccount> {
        public Collection(String uri) {
            super(BankAccount.class, uri);
        }
    };

    public BankAccount() {
        super();
    }

    public BankAccount(String uri) throws HTTPError {
        super(uri);
    }

    public BankAccount(Map<String, Object> payload) {
        super(payload);
    }

    public static ResourceQuery<Marketplace> query() {
        return new ResourceQuery<Marketplace>(Marketplace.class, root_uri);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null) {
            uri = root_uri;
        }
        super.save();
    }

    public BankAccountVerification verify() throws HTTPError {
        return verifications.create();
    }

    public BankAccountVerification getVerification() throws HTTPError {
        if (verification_uri == null) {
            return null;
        }
        return new BankAccountVerification(verification_uri);
    }
}
