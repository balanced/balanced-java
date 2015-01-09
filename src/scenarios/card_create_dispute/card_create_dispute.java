package card_create_dispute;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_create_dispute {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("number", "6500000000000002");
payload.put("expiration_month", 12);
payload.put("expiration_year", 3000);
payload.put("cvv", "123");

Card card = new Card(payload);
try {
    card.save();
}
catch (HTTPError e) {}

}
}

