package customer_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU5AxbQrjAcjsbquafnvwaas");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

}
}

