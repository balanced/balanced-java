package refund_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Refund refund = new Refund("/v1/customers/CUuDKfPHvZhTmaNbEsg1BOO/refunds/RFHBiohkzkfO6RPYOrjc9US");

}
}

