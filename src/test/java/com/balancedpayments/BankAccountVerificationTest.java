package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.balancedpayments.errors.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BankAccountVerificationTest extends BaseTest {

    @Test(expected=APIError.class)
    public void testFailedConfirm() throws CannotCreate, HTTPError {
        BankAccount ba = createBankAccount();
        ba.verify();
        ba.reload();
        BankAccountVerification bav = ba.verification;
        bav.confirm(12, 13);
    }

    @Test(expected=APIError.class)
    public void testDoubleConfirm() throws CannotCreate, HTTPError {
        BankAccount ba = createBankAccount();
        ba.verify();
        ba.reload();
        BankAccountVerification bav = ba.verification;
        bav.confirm(1, 1);
        bav.confirm(1, 1);
    }

    @Test
    public void testExhaustedConfirm() throws CannotCreate, HTTPError {
        BankAccount ba = createBankAccount();
        ba.verify();
        ba.reload();
        BankAccountVerification bav = ba.verification;
        while (bav.attempts_remaining != 1) {
            try {
                bav.confirm(12, 13);
            }
            catch (APIError e){
                bav = new BankAccountVerification(bav.href);
                assertEquals(bav.deposit_status, "succeeded");
            }
        }
        try {
            bav.confirm(12, 13);
        }
        catch (APIError e){
            bav = new BankAccountVerification(bav.href);
            assertEquals(bav.verification_status, "failed");
        }
        assertEquals(bav.attempts_remaining.intValue(), 0);
        bav = ba.verify();
        bav.confirm(1, 1);
        assertEquals(bav.verification_status, "succeeded");
    }
}
