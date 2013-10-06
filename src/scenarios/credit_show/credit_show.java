package credit_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Credit credit = new Credit("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/credits/CR6Y384863fzeb73YbW5NHVe");

}
}

