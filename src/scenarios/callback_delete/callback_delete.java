package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Callback callback = new Callback();
callback.save();
try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

}
}

