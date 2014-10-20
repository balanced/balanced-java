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
    public void testMarketplaceResourceFields() throws HTTPError,
            NoResultsFound, MultipleResultsFound{
        Marketplace marketplace = Marketplace.mine();

        assertNotNull(marketplace.in_escrow);
        assertNotNull(marketplace.domain_url);
        assertNotNull(marketplace.name);
        assertNotNull(marketplace.owner_customer);
        assertNotNull(marketplace.href);
        assertNotNull(marketplace.created_at);
        assertNotNull(marketplace.support_email_address);
        assertNotNull(marketplace.updated_at);
        assertNotNull(marketplace.support_email_address);
        assertNotNull(marketplace.support_phone_number);
        assertNotNull(marketplace.production);
        assertNotNull(marketplace.meta);
        assertNotNull(marketplace.unsettled_fees);
        assertNotNull(marketplace.id);
        assertNotNull(marketplace.debits);
        assertNotNull(marketplace.reversals);
        assertNotNull(marketplace.disputes);
        assertNotNull(marketplace.customers);
        assertNotNull(marketplace.credits);
        assertNotNull(marketplace.cards);
        assertNotNull(marketplace.orders);
        assertNotNull(marketplace.card_holds);
        assertNotNull(marketplace.refunds);
        assertNotNull(marketplace.bank_accounts);
        assertNotNull(marketplace.callbacks);
        assertNotNull(marketplace.events);
    }
}
