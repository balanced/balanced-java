package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Callback callback = new Callback("/callbacks/CB6K21Z5b8imJRPeZEBoHPq");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

