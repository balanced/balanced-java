package com.balanced;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.balanced.errors.CannotCreate;
import com.balanced.errors.HTTPError;
import com.balanced.errors.MultipleResultsFound;
import com.balanced.errors.NoResultsFound;

public class DebitTest extends BaseTest {

    @Test
    public void testRefund() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mp = Marketplace.mine();
        Account account = createBuyer(mp);
        Debit debit = account.debit(123);
        Refund refund = debit.refund();
        assertEquals(refund.amount, debit.amount);
    }
}
