package com.balancedpayments;


import com.balancedpayments.errors.HTTPError;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DisputeTest extends BaseTest {

    @Test
    public void testDispute() throws HTTPError, InterruptedException {
        Customer customer = createPersonCustomer();

        Map<String, Object> cardPayload = new HashMap<String, Object>();
        cardPayload.put("number", "6500000000000002");
        cardPayload.put("cvv", "123");
        cardPayload.put("expiration_month", 12);
        cardPayload.put("expiration_year", 3000);

        Card card = new Card(cardPayload);
        card.save();

        card.associateToCustomer(customer);

        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("amount", 100000);
        payload.put("description", "Donuts");

        String debit_href = card.debit(payload).href;
        Dispute dispute = null;

        for (int i = 0; i <= 100; i++) {
            Debit debit = new Debit(debit_href);
            if (debit.dispute != null) {
                dispute = debit.dispute;
                break;
            }
            System.out.println("polling disputes...");
            Thread.sleep(10000);
        }
        
        assertNotNull(dispute);
        assertEquals(100000, dispute.amount.intValue());
        assertEquals("fraud", dispute.reason);
        assertEquals("pending", dispute.status);

        assertEquals(dispute.amount.toString(), "100000");
        assertNotNull(dispute.created_at);
        assertEquals(dispute.currency, "USD");
        assertTrue(dispute.href.contains("/disputes/DT"));
        assertTrue(dispute.id.startsWith("DT"));
        assertNotNull(dispute.initiated_at);
        assertTrue(dispute.transaction instanceof Debit);
        assertEquals(dispute.reason, "fraud");
        assertNotNull(dispute.respond_by);
        assertEquals(dispute.status, "pending");
        assertNotNull(dispute.updated_at);
        assertTrue(dispute.events instanceof Event.Collection);
    }
}
