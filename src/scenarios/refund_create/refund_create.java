package refund_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Debit debit = new Debit("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/debits/WDE7lu1wLfsf2JhWHYM6U2W");
debit.refund();

}
}

