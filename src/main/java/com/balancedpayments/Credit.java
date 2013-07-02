package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;

import com.balancedpayments.errors.HTTPError;

public class Credit extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField()
    public Integer amount;

    @ResourceField()
    public String description;

    @ResourceField()
    public String status;

    @ResourceField()
    public BankAccount bank_account;

    @ResourceField()
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public Customer customer;

    @ResourceField(field="reversals_uri")
    public Reversal.Collection reversals;

    public Credit() {
	super();
    }

    public Credit(String uri) throws HTTPError {
	super(uri);
    }

    public Reversal reverse(
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
	return reversals.create(payload);
    }

    public Reversal reverse(int amount) throws HTTPError {
	return reverse(amount, null, null);
    }

    public Reversal reverse() throws HTTPError {
	return reverse(null, null, null);
    }

    public static class Collection extends ResourceCollection<Credit> {
	public Collection(String uri) {
	    super(Credit.class, uri);
	}
    }
}
