package reversal_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class reversal_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Credit credit = new Credit("/credits/CR6zeufmfv0u1KHrUBCQtAgU");

HashMap<String, Object> meta = new HashMap<String, Object>();
meta.put("user.refund_reason", "not happy with product");
meta.put("merchant.feedback", "positive");
meta.put("fulfillment.item.condition", "OK");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 3000);
payload.put("description", "Reversal for Order #1111");
payload.put("meta", meta);

try {
    credit.reverse(payload);
}
catch (HTTPError e) {}

}
}

