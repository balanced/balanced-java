package customer_add_card;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class customer_add_card {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU5K29KHV21jnwgxVe2rW5nF");
customer.addCard("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC5LSyXneU8VvRVdq9MSVbh6");

}
}

