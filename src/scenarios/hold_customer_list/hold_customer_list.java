package hold_customer_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_customer_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CUcKunVjtvF7v8JlC5ZBdeM");
Hold.Collection holds = customer.holds;

}
}

