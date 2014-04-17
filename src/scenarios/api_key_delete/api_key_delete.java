package api_key_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class api_key_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

ApiKey key = new ApiKey("/api_keys/AK7EjZ7fq7gpLRj9HQNh12UE");
try {
    key.unstore();
}
catch (APIError e) {}
catch (NotCreated notCreated) {}

}
}

