package refund_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Debit debit = new Debit("/debits/WD57kmfV9Cgc0MiZkHOmFU1z");

try {
    debit.refund();
}
catch (HTTPError e) {}

}
}

