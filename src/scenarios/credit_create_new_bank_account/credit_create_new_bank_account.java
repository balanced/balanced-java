package credit_create_new_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_create_new_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Map<String, Object> bankAccountPayload = new HashMap<String, Object>();
bankAccountPayload.put("name", "Johann Bernoulli");
bankAccountPayload.put("routing_number", "121000358");
bankAccountPayload.put("account_number", "9900000001");
bankAccountPayload.put("type", "checking");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 10000);
payload.put("bank_account", bankAccountPayload);

Credit credit = new Credit(payload);
credit.save();

}
}

