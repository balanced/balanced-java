package customer_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Map<String, Object> address = new HashMap<String, Object>();
address.put("postal_code", "48120");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "Henry Ford");
payload.put("dob_month", 7);
payload.put("dob_year", 1963);
payload.put("address", address);

Customer customer = new Customer(payload);

try {
    customer.save();
}
catch (HTTPError e) {}

}
}

