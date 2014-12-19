package com.balancedpayments;

import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SettlementTest extends BaseTest {
    @Test
    public void testSettlement() throws HTTPError, MultipleResultsFound,
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

        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        Settlement settlement = payableAccount.settle(settlementPayload);
        payableAccount.reload();

        assertEquals(payableAccount.balance.intValue(), 0);
        assertEquals(settlement.amount.intValue(), 5000);
    }

    @Test
    public void testReverseSettledAccountCredit()
            throws HTTPError, MultipleResultsFound,
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

        Credit credit = payableAccount.credit(creditPayload);
        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        payableAccount.settle(settlementPayload);
        payableAccount.reload();

        Order order_two = merchant.createOrder(null);
        Map<String, Object> debitTwoPayload = new HashMap<String, Object>();
        debitTwoPayload.put("description", "Debit for Order #234123");
        debitTwoPayload.put("amount", 5000);
        order_two.debitFrom(card, debitTwoPayload);

        Map<String, Object> creditTwoPayload = new HashMap<String, Object>();
        creditTwoPayload.put("description", "Payout for Order #234123");
        creditTwoPayload.put("amount", 5000);
        creditTwoPayload.put("order", order_two.href);

        payableAccount.credit(creditTwoPayload);
        payableAccount.reload();
        assertEquals(payableAccount.balance.intValue(), 5000);

        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 5000);
        credit.reverse(payload);

        payableAccount.reload();
        assertEquals(payableAccount.balance.intValue(), 0);
    }

    @Test
    public void testReverseSettledCreditSettlementNegativeBalance()
            throws HTTPError, MultipleResultsFound,
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

        Credit credit = payableAccount.credit(creditPayload);

        Map<String, Object> settlementPayload = new HashMap<String, Object>();
        settlementPayload.put("funding_instrument", ba.href);
        settlementPayload.put("appears_on_statement_as", "Oct Settlement");

        payableAccount.settle(settlementPayload);
        payableAccount.reload();

        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 5000);
        credit.reverse(payload);

        payableAccount.reload();
        assertEquals(payableAccount.balance.intValue(), -5000);

        Map<String, Object> settlementTwoPayload = new HashMap<String, Object>();
        settlementTwoPayload.put("funding_instrument", ba.href);
        settlementTwoPayload.put("appears_on_statement_as", "Oct Settlement");

        payableAccount.settle(settlementPayload);
        payableAccount.reload();
        assertEquals(payableAccount.balance.intValue(), 0);
    }
}