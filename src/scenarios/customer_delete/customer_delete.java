package customer_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer();

try {
    customer.unstore();
}
catch (NotCreated e) {
    // the customer didn't exist in the first place
}

}
}
