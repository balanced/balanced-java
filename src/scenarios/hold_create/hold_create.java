package hold_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU5V9hgMlkw8NMm7N2HZNzTk");
customer.addCard("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC5WFWuNSzBpYgfNqDb8RVLE");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("source_uri", "/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC5WFWuNSzBpYgfNqDb8RVLE");

Hold hold = new Hold(payload);
hold.save();

}
}
