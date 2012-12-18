package com.balanced;

import org.junit.Test;

import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class MerchantTest extends BaseTest {
	
	@Test
	public void testMe() throws HTTPError, NoResultsFound, MultipleResultsFound {
		Merchant.me();
	}
}
