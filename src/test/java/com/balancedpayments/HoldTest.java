package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HoldTest extends BaseTest {

    protected Account buyer;
    
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
    }

    @Test
    public void testCreate() throws CannotCreate, HTTPError, NotCreated {
        Customer customer = createBusinessCustomer();
        Card card = createCard(mp);
        customer.addCard(card);

        // create a hold
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);
        payload.put("source_uri", card.uri);
        Hold hold = new Hold(payload);
        hold.save();
        assertTrue(hold.amount == 2000);
    }

    @Test
    public void testCapture() throws CannotCreate, HTTPError, NotCreated {
        Customer customer = createBusinessCustomer();
        Card card = createCard(mp);
        customer.addCard(card);

        // create a hold
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 2000);
        payload.put("source_uri", card.uri);
        Hold hold = new Hold(payload);
        hold.save();

        // capture the hold
        payload = new HashMap<String, Object>();
        payload.put("amount", 1925);
        payload.put("appears_on_statement_as", "BagelHub TastyBagels");
        hold = new Hold(hold.uri);
        Debit debit = hold.capture(payload);
        assertTrue(debit.amount == 1925);
        assertTrue(debit.appears_on_statement_as.equals("BagelHub TastyBagels"));
    }

    @Test
    public void testAccountHoldVoid() throws HTTPError {
        buyer = createBuyer(this.mp);
        Hold hold = buyer.hold(123);
        hold.void_();
        assertTrue(hold.is_void);
        assertTrue(Hold.get(hold.uri).is_void);
    }
    
    @Test
    public void testAccountHoldDoubleVoid() throws HTTPError {
        buyer = createBuyer(this.mp);
        Hold hold = buyer.hold(123);
        hold.void_();
        assertTrue(hold.is_void);
        assertTrue(Hold.get(hold.uri).is_void);
        hold.void_();
    }
    
    @Test
    public void testAccountHoldPartialCapture() throws HTTPError {
        buyer = createBuyer(this.mp);
        Hold hold = buyer.hold(123);
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 100);
        Debit debit = hold.capture(payload);
        assertEquals(debit.amount.intValue(), 100);
    }
    
    @Test
    public void testAccountHoldCapture() throws HTTPError {
        buyer = createBuyer(this.mp);
        Hold hold = buyer.hold(123);
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 123);
        Debit debit = hold.capture(payload);
        assertEquals(debit.amount, hold.amount);
    }
}
