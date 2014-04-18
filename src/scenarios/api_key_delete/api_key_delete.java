package api_key_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class api_key_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

ApiKey key = new ApiKey("/api_keys/AK7KGjv4YKtOf03Lqm0f84V");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

}
}

