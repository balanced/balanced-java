package card_create_creditable;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_create_creditable {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "Johannes Bach");
payload.put("number", "4342561111111118");
payload.put("expiration_month", 05);
payload.put("expiration_year", 2020);

Card card = new Card(payload);
try {
    card.save();
}
catch (HTTPError e) {}

}
}

