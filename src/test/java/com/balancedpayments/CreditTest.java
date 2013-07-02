package com.balancedpayments;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.balancedpayments.core.ResourceQuery;
import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class CreditTest extends BaseTest {

    @Test
    public void testReversal() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
	Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
	Account account2 = createMerchant(mp);
	Credit credit = account2.credit(123);
	Reversal reversal = credit.reverse();
	assertEquals(reversal.amount, credit.amount);
    }


}
