package com.balancedpayments.errors;

public class CardNotAssociated extends Exception {

    public CardNotAssociated() {
        super("The card has not been associated with either a customer or an account");
    }

}


