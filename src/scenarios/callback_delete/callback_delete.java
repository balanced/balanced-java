package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Callback callback = new Callback("/v1/callbacks/CB6DYHGJOCaSxYwDz34j5TGa");

try {
    callback.delete();
}
catch (NotCreated e) {
    // the callback didn't exist in the first place
}

}
}

