package customer_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "William Henry Cavendish III");
payload.put("email", "william@example.com");

Customer customer = new Customer(payload);
customer.save();

}
}

