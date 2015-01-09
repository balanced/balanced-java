package api_key_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class api_key_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

ApiKey key = new ApiKey("/api_keys/AK3DQGzROuoRYulKXMQdHBxX");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

}
}

