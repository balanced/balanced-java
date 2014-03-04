package com.balancedpayments;

import java.util.ArrayList;
import java.util.Map;

import com.balancedpayments.core.Resource;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class Marketplace extends Resource {

    private static final String resource_href = "/marketplaces";

    // fields

    @ResourceField(mutable=true)
    public String domain_url;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String support_email_address;

    @ResourceField(mutable=true)
    public String support_phone_number;

    // attributes

    @ResourceField()
    public Integer in_escrow;

    @ResourceField(field="marketplaces.bank_accounts")
    public BankAccount.Collection bank_accounts;

    @ResourceField(field="marketplaces.callbacks")
    public Callback.Collection callbacks;

    @ResourceField(field="marketplaces.cards")
    public Card.Collection cards;

    @ResourceField(field="marketplaces.customers")
    public Customer.Collection customers;

    @ResourceField(field="marketplaces.credits")
    public Credit.Collection credits;

    @ResourceField(field="marketplaces.card_holds")
    public CardHold.Collection card_holds;

    @ResourceField(field="marketplaces.debits")
    public Debit.Collection debits;

    @ResourceField(field="marketplaces.events")
    public Event.Collection events;

    @ResourceField(field="marketplaces.refunds")
    public Refund.Collection refunds;

    @ResourceField(field="marketplaces.reversals")
    public Reversal.Collection reversals;

    @ResourceField(field="marketplaces.owner_customer")
    public Customer owner_customer;

    @ResourceField()
    public Boolean production;

    @ResourceField()
    public Integer unsettled_fees;


    public static ResourceQuery<Marketplace> query() {
        return new ResourceQuery<Marketplace>(
                Marketplace.class, resource_href);
    }

    public static Marketplace mine() throws NoResultsFound, MultipleResultsFound, HTTPError {
        ArrayList<Marketplace> mps = Marketplace.query().all();
        return mps.get(0);
    }

    public Marketplace() {
        super();
    }

    public Marketplace(String href) throws HTTPError {
        super(href);
    }

    @Override
    public void save() throws HTTPError {
        if (id == null && href == null)
            href = resource_href;
        super.save();
    }
}
