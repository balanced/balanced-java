package refund_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Refund refund = new Refund("/v1/customers/CU5eN73VZL9xr3qR4VIgtTZI/refunds/RF5tlXeMsrSsrDfJdLEDrDsP");

}
}

