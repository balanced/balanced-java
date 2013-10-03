package customer_add_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_add_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4lgbQNfVGHYdW92fsHu9z8");
customer.addBankAccount("/v1/bank_accounts/BA4mVwPx6PesFr2ep0CUbEHS");

}
}

