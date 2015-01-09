package bank_account_verification_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_verification_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3LVXVgJLrzkmB3vUntKJ6t");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

}
}

