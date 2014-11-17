package card_hold_order;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_hold_order {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC33DRVrekWpiHYjxSdVuqWc");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("order", "/orders/OR5sl2RJVnbwEf45nq5eATdz");

try {
    CardHold cardHold = card.hold(payload);
}
catch (HTTPError e) {}

}
}

