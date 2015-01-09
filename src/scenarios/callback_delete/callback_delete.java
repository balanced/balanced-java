package callback_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Callback callback = new Callback("/callbacks/CB3BP8jjVy8RBUFdb2fYw0mh");

try {
    callback.delete();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

