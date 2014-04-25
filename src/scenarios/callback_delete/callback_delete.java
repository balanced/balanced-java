package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Callback callback = new Callback("/callbacks/CB44XaMOcxsUnuQoA5A4VKCx");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

