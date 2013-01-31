package com.balancedpayments;

import org.junit.Test;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class MerchantTest extends BaseTest {
    
    @Test
    public void testMe() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Merchant.me();
    }
}
