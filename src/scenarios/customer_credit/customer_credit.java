package customer_credit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_credit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU6bg92aGrSXuWUF6usdhBbw");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 100);

customer.credit(payload);

}
}

