package credit_create_new_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_create_new_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "Johann Bernoulli");
payload.put("routing_number", "121000358");
payload.put("account_number", "9900000001");
payload.put("type", "checking");

BankAccount ba = new BankAccount(payload);
ba.save();

ba.credit(10000);

}
}
