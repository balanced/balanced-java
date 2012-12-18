package com.balanced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

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
}
