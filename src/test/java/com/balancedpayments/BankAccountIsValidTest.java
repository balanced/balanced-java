package com.balancedpayments;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.balancedpayments.errors.BankAccountVerificationFailure;
import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class BankAccountIsValidTest  extends BaseTest {

    protected BankAccount ba;

    @Override
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Account account = mp.createAccount("Homer Jay");
        ba = createBankAccount(mp);
        account.associateBankAccount(ba.uri);
        ba.save();
    }

    @Test
    public void testSoftDeleteOfBankAccountFromAssociatedBankAccount() throws CannotCreate, HTTPError, NotCreated {
        assertEquals(ba.is_valid, true);
        ba.delete();
        ba.save();
        assertEquals(ba.is_valid, false);
    }
    
    @Test
    public void testSofDeleteOfBankAccount() throws HTTPError{
    	BankAccount bankAccount = new BankAccount();
    	bankAccount.name = "Harry Fakester";
    	bankAccount.routing_number = "121042882";
    	bankAccount.account_number = "112233a";
    	bankAccount.type = "checking";
    	bankAccount.save();
    	assertEquals(ba.is_valid, null);
    	
    }
}
