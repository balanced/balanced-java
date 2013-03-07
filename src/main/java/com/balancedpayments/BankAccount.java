package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;

public class BankAccount extends Resource {
    
    public Date created_at;
    public String name;
    public String account_number;
    public String routing_number;
    public String type;
    public String fingerprint;
    public String bank_name;
    public Map<String, String> meta;
    public String verifications_uri;
    public BankAccountVerification.Collection verifications;
    public String verification_uri;
    
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
        return new ResourceQuery<Marketplace>(
                Marketplace.class,
                "/v" + Settings.VERSION + "/bank_accounts");
    }
    
    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null) {
            uri = "/v" + Settings.VERSION + "bank_accounts";
        }
        super.save();
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", name);
        payload.put("account_number", account_number);
        payload.put("routing_number", routing_number);
        payload.put("type", type);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        created_at = deserializeDate((String) payload.get("created_at"));
        name = (String) payload.get("name");
        account_number = (String) payload.get("account_number");
        routing_number = (String) payload.get("routing_number");
        type = (String) payload.get("type");
        fingerprint = (String) payload.get("fingerprint");
        bank_name = (String) payload.get("bank_name");
        meta = (Map<String, String>) payload.get("meta");
        verifications_uri = (String) payload.get("verifications_uri");
        verifications = new BankAccountVerification.Collection(verifications_uri);
        verification_uri = (String) payload.get("verification_uri");
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
