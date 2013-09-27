package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

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

