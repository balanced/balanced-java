package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.errors.*;

public class QuickStart {

    public static void main(String [] args) throws HTTPError, NoResultsFound, MultipleResultsFound, NotCreated {
        ApiKey key = new ApiKey();
        key.save();
        System.out.printf("Our secret is %s\n", key.secret);

        System.out.printf("Configure with our secret\n");
        Balanced.configure(key.secret);

        System.out.printf("Create marketplace\n");
        Marketplace mp = new Marketplace();
        mp.save();

        System.out.printf("Whats my marketplace? Easy Marketplace.mine().href -> %s\n", Marketplace.mine().href);

        System.out.printf("My marketplace's name is: %s\n", mp.name);
        System.out.printf("Changing it to TestFooey.\n");
        mp.name = "TestFooey";
        mp.save();
        System.out.printf("My marketplace's name is now: %s\n", mp.name);

        System.out.printf("Cool, let's create (tokenize) a card!\n");

        Map<String, Object> cardPayload = new HashMap<String, Object>();
        cardPayload.put("name", "John Jameson");
        cardPayload.put("number", "5105105105105100");
        cardPayload.put("expiration_month", 12);
        cardPayload.put("expiration_year", 2020);
        cardPayload.put("cvv", "123");

        Card buyerCard = new Card(cardPayload);
        buyerCard.save();

        System.out.printf("Our card is %s.\n", buyerCard.href);

        System.out.println("Create a buyer customer.");

        Map<String, Object> buyerPayload = new HashMap<String, Object>();
        buyerPayload.put("name", "John Jameson");

        Customer buyer = new Customer(buyerPayload);
        buyer.save();
        System.out.printf("Our buyer customer is %s.\n", buyer.href);

        System.out.printf("Associate the card to the buyer.\n");
        buyerCard.associateToCustomer(buyer);

        System.out.printf("Create a $15 hold on the buyer's card.\n");
        Map<String, Object> holdPayload = new HashMap<String, Object>();
        holdPayload.put("amount", 1500);
        CardHold cardHold = buyerCard.hold(holdPayload);

        System.out.println("Now capture that money");
        Debit debit = cardHold.capture();
        System.out.printf("Which gives us this debit, %s\n", debit.href);

        mp.reload();
        System.out.printf("Now we have %s in escrow.\n", mp.in_escrow);

        System.out.printf("Now refund the full amount.\n");
        Refund refund = debit.refund();

        mp.reload();
        System.out.printf("Now we have %s in escrow.\n", mp.in_escrow);
    }
}
