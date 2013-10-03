package customer_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4pU7o8tYkqaGTvf1UQXAFG");

try {
    customer.unstore();
}
catch (NotCreated e) {
    // the customer didn't exist in the first place
}

}
}

