package com.balancedpayments;

import static org.junit.Assert.*;

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
            catch (APIError e) {
                bav = new BankAccountVerification(bav.href);
                assertEquals("pending", bav.verification_status);
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
        assertEquals("succeeded", bav.verification_status);
        assertEquals(ba.href, bav.bank_account.href);
    }

    @Test
    public void testVerificationResourceFields() throws HTTPError {
        BankAccount bankAccount = createdAssociatedBankAccount();
        BankAccountVerification verification = bankAccount.verify();

        assertEquals(verification.attempts.toString(), "0");
        assertEquals(verification.attempts_remaining.toString(), "3");
        assertNotNull(verification.created_at);
        assertEquals(verification.deposit_status, "succeeded");
        assertTrue(verification.href.contains("/verifications/BZ"));
        assertTrue(verification.id.contains("BZ"));
        assertEquals(verification.bank_account.href, bankAccount.href);
        assertNotNull(verification.updated_at);
        assertEquals(verification.verification_status, "pending");
    }
}
