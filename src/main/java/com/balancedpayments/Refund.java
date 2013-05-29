package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;

public class Refund extends Resource {
    
    public Date created_at;
    public Map<String, String> meta;
    public Integer amount;
    public String description;
    public Account account;
    public String appears_on_statement_as;
    public String transaction_number;
    public Debit debit;
    public String account_uri;
    
    public static class Collection extends ResourceCollection<Refund> {
        public Collection(String uri) {
            super(Refund.class, uri);
        }
    };

    public Refund() {
        super();
    }
    
    public Refund(Map<String, Object> payload) {
        super(payload);
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", amount);
        payload.put("description", description);
        payload.put("appears_on_statement_as", appears_on_statement_as);
        payload.put("meta", meta);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        created_at = deserializeDate((String) payload.get("created_at"));
        meta = (Map<String, String>) payload.get("meta");
        amount = ((Double) payload.get("amount")).intValue();
        description = (String) payload.get("description");
        appears_on_statement_as = (String) payload.get("appears_on_statement_as");
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
        debit = new Debit((Map<String, Object>) payload.get("debit"));
    }
}
