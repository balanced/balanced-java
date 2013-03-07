package com.balancedpayments;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.balancedpayments.errors.BankAccountVerificationFailure;
import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class BankAccountVerificationTest extends BaseTest {
    
    protected BankAccount ba;
    protected BankAccountVerification bav;
    
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Account account = mp.createAccount("Homer Jay");
        ba = createBankAccount(mp);
        account.associateBankAccount(ba.uri);
        bav = ba.verify();
    }

    @Test(expected=BankAccountVerificationFailure.class)
    public void testFailedConfirm() throws CannotCreate, HTTPError {
        bav.confirm(12, 13);
    }
    
    @Test(expected=BankAccountVerificationFailure.class)
    public void testDoubleConfirm() throws CannotCreate, HTTPError {
        bav.confirm(1, 1);
        bav.confirm(1, 1);
    }
    
    @Test
    public void testExhaustedConfirm() throws CannotCreate, HTTPError {
        while (bav.remaining_attempts != 1) {
            try {
                bav.confirm(12, 13);
            }
            catch (BankAccountVerificationFailure e){
                bav = new BankAccountVerification(bav.uri);
                assertEquals(bav.state, "pending");
            }
        }
        try {
            bav.confirm(12, 13);
        }
        catch (BankAccountVerificationFailure e){
            bav = new BankAccountVerification(bav.uri);
            assertEquals(bav.state, "failed");
        }
        assertEquals(bav.remaining_attempts.intValue(), 0);
        bav = ba.verify();
        bav.confirm(1, 1);
        assertEquals(bav.state, "verified");
    }
}
