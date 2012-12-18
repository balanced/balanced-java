package com.balanced;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balanced.core.Resource;
import com.balanced.core.ResourceCollection;
import com.balanced.errors.HTTPError;

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
	public ResourceCollection<Refund> refunds;
	
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
			account = Account.get(account_uri);
		return account;
	}
	
	public Card getCard() throws HTTPError {
		if (card == null)
			card = Card.get(card_uri);
		return card;
	}

	public Hold getHold() throws HTTPError {
		if (hold == null)
			hold = Hold.get(hold_uri);
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
		refunds = new ResourceCollection<Refund>(Refund.class, refunds_uri);
	}
}
