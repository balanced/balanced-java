package api_key_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class api_key_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

ApiKey key = new ApiKey("/api_keys/AK5GPcrSGuD1jtq6cEctwa3j");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

}
}

