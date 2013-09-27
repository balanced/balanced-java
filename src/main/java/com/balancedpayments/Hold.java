package com.balancedpayments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;

public class Hold extends Resource {

    @ResourceField()
    public Date created_at;

    @ResourceField(mutable=true)
    public Map<String, String> meta;

    @ResourceField(mutable=true)
    public Integer amount;

    @ResourceField()
    public Date expires_at;

    @ResourceField(mutable=true)
    public String description;

    @ResourceField(mutable=true)
    public String appears_on_statement_as;

    @ResourceField()
    public Debit debit;

    @ResourceField(mutable=true)
    public String transaction_number;

    @ResourceField(mutable=true)
    public Boolean is_void;

    @ResourceField(required=false)
    public String account_uri;

    @ResourceField(required=false)
    public Account account;

    @ResourceField(required=false)
    public String card_uri;

    @ResourceField(mutable=true, required=false)
    public String source_uri;

    @ResourceField(required=false)
    public Card card;

    @ResourceField(required=false)
    public FundingInstrument source;

    public static class Collection extends ResourceCollection<Hold> {
        public Collection(String uri) {
            super(Hold.class, uri);
        }
    };

    public static Hold get(String uri) throws HTTPError {
        return new Hold((Balanced.getInstance().getClient()).get(uri));
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

    @Override
    public void save() throws HTTPError {
        if (id == null && uri == null)
            uri = String.format("/v%s/%s", Balanced.getInstance().getAPIVersion(), "holds");
        super.save();
    }

    public Account getAccount() throws HTTPError {
        if (account == null)
            account = new Account(account_uri);
        return account;
    }

    public Card getCard() throws HTTPError {
        if (card == null) {
            if (card_uri != null) {
                return card = new Card(card_uri);
            }
            else if (source.uri != null) {
                return card = new Card(source.uri);
            }
        }

        return null;
    }

    public void void_() throws HTTPError {
        is_void = true;
        save();
    }

    public Debit capture(Map<String, Object> payload) throws HTTPError {
        payload.put("hold_uri", uri);
        debit = account.debits.create(payload);
        return debit;
    }

    public Debit capture() throws HTTPError {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("hold_uri", uri);
        debit = account.debits.create(payload);
        return debit;
    }
}
