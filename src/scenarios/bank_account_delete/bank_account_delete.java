package bank_account_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3Cc1WHeLCM0GhP6havpp7N");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

}
}

