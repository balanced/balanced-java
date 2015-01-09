package callback_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("url", "http://www.example.com/callback_test");
payload.put("method", "post");

Callback callback = new Callback(payload);

try {
    callback.save();
}
catch (HTTPError e) {}

}
}

