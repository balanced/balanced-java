package bank_account_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3Ya2sAlEQE14O1iS17FN0Q");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

