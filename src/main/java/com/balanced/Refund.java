package com.balanced;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balanced.core.Resource;

public class Refund extends Resource {
    
    public Date created_at;
    public Map<String, String> meta;
    public Integer amount;
    public String description;
    public Account account;
    public String appears_on_statement_as;
    public String transaction_number;
    public Debit debit;

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
        account = new Account((Map<String, Object>) payload.get("account"));
        debit = new Debit((Map<String, Object>) payload.get("debit"));
    }
}
