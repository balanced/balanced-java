package com.balanced;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balanced.core.Resource;

public class Credit extends Resource {
    
    public Date created_at;
    public Integer amount;
    public String description;
    public String status;
    public BankAccount bank_account;
    public String account_uri;
    public Account account;
    public Map<String, String> meta;
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("meta", meta);
        return payload;
    }

    @Override
    public void deserialize(Map<String, Object> payload) {
        super.deserialize(payload);
        if (payload.containsKey("account_uri")) {
            account = null;
            account_uri = (String) payload.get("account_uri");
        }
        else if (payload.containsKey("account")) {
            account = new Account((Map<String, Object>) payload.get("account"));
            account_uri = account.uri;
        }
        else {
            account = null;
            account_uri = null;
        }
        bank_account = new BankAccount((Map<String, Object>) payload.get("bank_account"));
        created_at = deserializeDate((String) payload.get("created_at"));
        amount = ((Double) payload.get("amount")).intValue();
        description = (String) payload.get("description ");
        status = (String) payload.get("status");
        meta = (Map<String, String>) payload.get("meta");
    }
}
