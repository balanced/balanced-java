package hold_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;

public class hold_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

CardHold.Collection holds = new CardHold.Collection("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/holds");

}
}

