package order_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class order_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("/customers/CU116TOiXnCfxHyDErDcMtpU");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("description", "Order #12341234");

try {
    customer.createOrder(payload);
}
catch (HTTPError e) {}

}
}

