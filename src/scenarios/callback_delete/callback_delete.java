package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Callback callback = new Callback("/callbacks/CBwxLHWPLsoBqKqVyUvZRKp");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

