package refund_customer_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_customer_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CUuDKfPHvZhTmaNbEsg1BOO");
Refund.Collection refunds = customer.refunds;

}
}

