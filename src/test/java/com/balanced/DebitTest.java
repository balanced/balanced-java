package com.balanced;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.balanced.core.ResourceQuery;
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
    
    @Test
    public void testDebitFilter() throws CannotCreate, HTTPError, NoResultsFound, MultipleResultsFound {
    	Marketplace mp = Marketplace.mine();
    	Account buyer;
    	Debit[] debits = new Debit[3];
    	
    	buyer = createBuyer(mp);
    	debits[0] = buyer.debit(55);
        debits[1] = buyer.debit(66);
        debits[2] = buyer.debit(77);

        ResourceQuery<Debit> query = buyer.debits.query().filter("amount", "=", 77);
        assertEquals(1, query.total());
        assertEquals(debits[2].id, query.first().id);
        
        query = (
			buyer
			.debits
			.query()
			.filter("amount", "<", 77)
			.order_by("created_at", true)
		);
        assertEquals(2, query.total());
        ArrayList<Debit> all_debits = query.all();
        assertEquals(debits[0].id, all_debits.get(0).id);
        assertEquals(debits[1].id, all_debits.get(1).id);
    }
}
