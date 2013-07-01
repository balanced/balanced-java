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

public class BankAccountTest  extends BaseTest {

    protected BankAccount ba;

    @Override
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Account account = mp.createAccount("Homer Jay");
        ba = createBankAccount(mp);
        account.associateBankAccount(ba.uri);
    }

    @Test
    public void testVerify() throws CannotCreate, HTTPError {
        BankAccountVerification bav = ba.verify();
        ba = new BankAccount(ba.uri);
        assertEquals(ba.getVerification().id, bav.id);
        bav.confirm(1, 1);
        assertEquals(bav.attempts.intValue(), 1);
        assertEquals(bav.state, "verified");
    }

    @Test(expected=BankAccountVerificationFailure.class)
    public void testDoubleVerify() throws CannotCreate, HTTPError {
        ba.verify();
        ba.verify();
    }

    @Test
    public void testSoftDeleteOfBankAccountFromAssociatedBankAccount() throws CannotCreate, HTTPError, NotCreated {
    	ba.save();
        assertEquals(ba.is_valid, true);
        ba.unstore();
    }

    @Test
    public void testSofDeleteOfBankAccount() throws HTTPError{
    	BankAccount bankAccount = new BankAccount();
    	bankAccount.name = "Harry Fakester";
    	bankAccount.routing_number = "121042882";
    	bankAccount.account_number = "112233a";
    	bankAccount.type = "checking";
    	bankAccount.save();
    	assertEquals(bankAccount.is_valid, null);

    }

    @Test
    public void testCredit() {}

}
