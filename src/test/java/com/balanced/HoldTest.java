package com.balanced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class HoldTest extends BaseTest {
	
	protected Marketplace mp;
	protected Account buyer;
	
	@Before
	public void setUp() {
		super.setUp();
		try {
			mp = Marketplace.mine();
			buyer = createBuyer(mp);
		}
		catch (NoResultsFound e) {
			throw new RuntimeException(e);
		}
		catch (MultipleResultsFound e) {
			throw new RuntimeException(e);
		}
		catch (HTTPError e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Test
	public void testVoid() throws HTTPError {
		Hold hold = buyer.hold(123);
		hold.void_();
		assertTrue(hold.is_void);
		assertTrue(Hold.get(hold.uri).is_void);
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
