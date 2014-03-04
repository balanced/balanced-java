package com.balancedpayments;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.DuplicateAccountEmailAddress;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class MarketplaceTest extends BaseTest {

    @Test(expected = APIError.class)
    public void testDoubleCreate() throws HTTPError {
        Marketplace marketplace2 = new Marketplace();
        marketplace2.save();
    }

    @Test
    public void testMine() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mine = Marketplace.mine();
        assertEquals(mine.id, mp.id);
    }

    @Test
    public void testOwner() throws HTTPError, NoResultsFound, MultipleResultsFound {
        Marketplace mine = Marketplace.mine();
        assertNotNull(mine.owner_customer);
    }


    @Test
    public void testEvents() throws HTTPError, NotCreated, InterruptedException, NoResultsFound, MultipleResultsFound {
        /*String balancedEnv = System.getenv("BALANCED_ENV");
        org.junit.Assume.assumeTrue((balancedEnv != "staging"));
        Marketplace mp = createMarketplace();
        int prev = mp.events.total();
        Account account = createBuyer(mp);
        account.debit(123);
        int cur = mp.events.total();
        int count = 0;
        while (cur == prev && count < 60) {
            System.out.println(String.format("waiting for events - %d, %d == %d...", count, cur, prev));
            Thread.sleep(2000);  // 2 seconds
            count += 1;
            cur = mp.events.total();
        }
        assertTrue(cur > prev);
        mp.events.all();*/
    }
}
