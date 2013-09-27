package bank_account_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("account_number", "9900000001");
payload.put("name", "Johann Bernoulli");
payload.put("routing_number", "121000358");
payload.put("type", "checking");

BankAccount bankAccount = new BankAccount(payload);

}
}

