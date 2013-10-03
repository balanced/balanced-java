package credit_create_existing_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_create_existing_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3GU9eoZ5YrnVZWPtmfZrNt");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);

ba.credit(payload);

}
}

