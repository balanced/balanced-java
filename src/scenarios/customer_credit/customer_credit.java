package customer_credit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_credit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU3QbHVO44v9opCiSdarCV14");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 100);

customer.credit(payload);

}
}

