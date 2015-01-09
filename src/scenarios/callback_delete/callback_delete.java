package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Callback callback = new Callback("/callbacks/CB4a7Q7HSdJJgMVHwPsarIw8");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

