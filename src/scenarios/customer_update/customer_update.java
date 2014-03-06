package customer_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("/customers/CU4xpIqZ7mf2fuLpBoXgoG7m");

Map<String, String> meta = new HashMap<String, String>();
meta.put("shipping-preference", "ground");

customer.meta = meta;
customer.email = "email@newdomain.com";

customer.save();


}
}

