package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BankAccountVerificationTest extends BaseTest {

    protected BankAccount ba;
    protected BankAccountVerification bav;

    @Override
    @Before
    public void setUp() throws NoResultsFound, MultipleResultsFound, HTTPError {
        super.setUp();
        Account account = mp.createAccount("Homer Jay");
        ba = createBankAccount(mp);
        account.associateBankAccount(ba.uri);
        bav = ba.verify();
    }

    @Test
    public void testVerifyBankAccountNoCustomer() throws HTTPError {
        BankAccount ba = createBankAccount(mp);

        try {
            ba.verify();
            fail("Bank Account verification should fail when not associated to a Customer");
        }
        catch (APIError e) {
            assertEquals("bank-account-no-account", e.category_code);
        }
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
                assertEquals(bav.state, "deposit_succeeded");
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
