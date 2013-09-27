package bank_account_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3YXRiVoKoMJMhq3Bfwxyu2");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

}
}

