package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class HoldTest extends BaseTest {

    protected Account buyer;
    
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        buyer = createBuyer(this.mp);
    }
    
    @Test
    public void testVoid() throws HTTPError {
        Hold hold = buyer.hold(123);
        hold.void_();
        assertTrue(hold.is_void);
        assertTrue(Hold.get(hold.uri).is_void);
    }
    
    @Test
    public void testDoubleVoid() throws HTTPError {
        Hold hold = buyer.hold(123);
        hold.void_();
        assertTrue(hold.is_void);
        assertTrue(Hold.get(hold.uri).is_void);
        hold.void_();
    }
    
    @Test
    public void testPartialCapture() throws HTTPError {
        Hold hold = buyer.hold(123);
        Debit debit = hold.capture(100);
        assertEquals(debit.amount.intValue(), 100);
    }
    
    @Test
    public void testCapture() throws HTTPError {
        Hold hold = buyer.hold(123);
        Debit debit = hold.capture();
        assertEquals(debit.amount, hold.amount);
    }
    
    @Test
    public void captureWithAppearsOnStatementAs() throws HTTPError {
        String appearsOnStatementAs = "Statement text";
        Hold hold = buyer.hold(123);
        hold.appears_on_statement_as = appearsOnStatementAs;
        Debit debit = hold.capture();
        assertEquals(appearsOnStatementAs, debit.appears_on_statement_as);
    }
    
    @Test
    public void captureWithDescription() throws HTTPError {
        String description = "This is my description";
        Hold hold = buyer.hold(123);
        hold.description = description;
        Debit debit = hold.capture();
        assertEquals(description, debit.description);
    }
}
