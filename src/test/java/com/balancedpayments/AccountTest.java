package com.balancedpayments;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AccountTest extends BaseTest {
    @Test
    public void testAccountTransfer() throws HTTPError, MultipleResultsFound,
            NoResultsFound {
        Customer merchant = createPersonCustomer();
        Account payableAccount = merchant.payableAccount();

        BankAccount ba = createBankAccount();
        ba.associateToCustomer(merchant);
        Order order = merchant.createOrder(null);
        Card card = createCard();

        Map<String, Object> debitPayload = new HashMap<String, Object>();
        debitPayload.put("description", "Debit for Order #234123");
        debitPayload.put("amount", 5000);

        order.debitFrom(card, debitPayload);
        order.reload();

        Map<String, Object> creditPayload = new HashMap<String, Object>();
        creditPayload.put("description", "Payout for Order #234123");
        creditPayload.put("amount", 5000);
        creditPayload.put("order", order.href);

        payableAccount.credit(creditPayload);
        payableAccount.reload();
        assertEquals(payableAccount.balance.intValue(), 5000);
    }
}