package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.errors.HTTPError;

public class Debit extends Resource  {
    
    public Date created_at;
    public Map<String, String> meta;
    public Integer amount;
    public String description;
    public String transaction_number;
    public Card card;
    public String card_uri;
    public String account_uri;
    public Account account;
    public String hold_uri;
    public Hold hold;
    public String refunds_uri;
    public Refund.Collection refunds;
    
    public static class Collection extends ResourceCollection<Debit> {
		public Collection(String uri) {
			super(Debit.class, uri);
		}
	};
    
    public Debit() {
        super();
    }
    
    public Debit(Map<String, Object> payload) {
        super(payload);
    }
    
    public Refund refund(
            Integer amount,
            String description,
            Map<String, String> meta) throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        if (amount != null)
            payload.put("amount", amount);
        if (description != null)
            payload.put("description", description);
        if (meta != null)
            payload.put("meta", meta);
        return refunds.create(payload);
    }
    
    public Refund refund(int amount) throws HTTPError {
        return refund(amount, null, null);
    }
    
    public Refund refund() throws HTTPError {
        return refund(null, null, null);
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

    public Hold getHold() throws HTTPError {
        if (hold == null)
            hold = new Hold(hold_uri);
        return hold;
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> payload = new HashMap<String, Object>();
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
        transaction_number = (String) payload.get("transaction_number");
        if (payload.containsKey("account_uri")) {
            account = null;
            account_uri = (String) payload.get("account_uri");
        }
        else {
            account = new Account((Map<String, Object>) payload.get("account"));
            account_uri = account.uri;
        }
        if (payload.containsKey("source_uri")) {
            card = null;
            card_uri = (String) payload.get("source_uri");
        }
        else {
            card = new Card((Map<String, Object>) payload.get("source"));
            card_uri = card.uri;
        }
        if (payload.containsKey("hold_uri")) {
            hold = null;
            hold_uri = (String) payload.get("hold_uri");
        }
        else if (payload.containsKey("hold")) {
            hold = new Hold((Map<String, Object>) payload.get("hold"));
            hold_uri = hold.uri;
        }
        else {
            hold = null;
            hold_uri = null;
        }
        refunds_uri = (String) payload.get("refunds_uri");
        refunds = new Refund.Collection(refunds_uri);
    }
}
