package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Client;
import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class Hold extends Resource {
    
    public Date created_at;
    public Map<String, String> meta;
    public Integer amount;
    public Date expires_at;
    public String description;
    public Debit debit;
    public String transaction_number;
    public Boolean is_void;
    public String account_uri;
    public Account account;
    public String card_uri;
    public Card card;
    
    public static class Collection extends ResourceCollection<Hold> {
        public Collection(String uri) {
            super(Hold.class, uri);
        }
    };

    public static Hold get(String uri) throws HTTPError {
        return new Hold((new Client()).get(uri));
    }
    
    public Hold() {
        super();
    }
    
    public Hold(String uri) throws HTTPError {
        super(uri);
    }
    
    public Hold(Map<String, Object> payload) {
        super(payload);
    }
    
    public Account getAccount() throws HTTPError {
        if (account == null)
            account = new Account(account_uri);
        return account;
    }
    
    public Card getCard() throws HTTPError {
        if (card == null)
            card = new Card(card_uri);
        return card;
    }
    
    public void void_() throws HTTPError {
        is_void = true;
        save();
    }
    
    public Debit capture(int amount) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("hold_uri", uri);
        payload.put("amount", amount);
        debit = account.debits.create(payload);
        return debit;
    }
    
    public Debit capture() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("hold_uri", uri);
        debit = account.debits.create(payload);
        return debit;
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        payload.put("description", description);
        payload.put("is_void", is_void);
        payload.put("meta", meta);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        created_at = deserializeDate((String) payload.get("created_at"));
        meta = (Map<String, String>) payload.get("meta");
        amount = ((Double) payload.get("amount")).intValue();
        expires_at = deserializeDate((String) payload.get("expires_at"));
        description = (String) payload.get("description");
        is_void  = (Boolean) payload.get("is_void");
        if (payload.containsKey("account_uri")) {
            account = null;
            account_uri = (String) payload.get("account_uri");
        }
        else if (payload.containsKey("account") && payload.get("account") != null) {
            account = new Account((Map<String, Object>) payload.get("account"));
            account_uri = account.uri;
        }
        else {
            account = null;
            account_uri = null;
        }
        if (payload.get("debit") != null)
            debit = new Debit((Map<String, Object>) payload.get("debit"));
        else
            debit = null;
        if (payload.containsKey("source_uri")) {
            card = null;
            card_uri = (String) payload.get("source_uri");
        }
        else {
            card = new Card((Map<String, Object>) payload.get("source"));
            card_uri = card.uri;
        }
    }
}
