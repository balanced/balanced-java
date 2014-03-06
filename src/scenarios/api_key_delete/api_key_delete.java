package api_key_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class api_key_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

ApiKey key = new ApiKey("/api_keys/AK3zUFsQ8aJ3aae9ZylavXLp");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

}
}

