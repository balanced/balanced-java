package callback_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class callback_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Callback.Collection callbacks = new Callback.Collection("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/callbacks");

}
}

