package customer_create_debit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_create_debit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4sDLDP25PDb3P3BgFM6s4e");
customer.save();

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

customer.debit(payload);

}
}

