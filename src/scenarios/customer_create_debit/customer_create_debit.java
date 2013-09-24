package customer_create_debit;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_create_debit {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU4Nb7C4elOK1YDp1SE3XWHC");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

customer.debit(payload);

}
}
