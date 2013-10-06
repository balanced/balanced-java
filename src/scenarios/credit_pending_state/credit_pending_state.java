package credit_pending_state;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_pending_state {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount ba = new BankAccount();
ba.account_number = "9900000001";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 10000);

ba.credit(payload);

}
}

