package hold_show;

import com.balancedpayments.CardHold;

public class hold_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

CardHold cardHold = new CardHold("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/holds/HLgZ3lv8DVAtfnxDJmieJ5S");

}
}

