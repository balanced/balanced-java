package debit_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Debit.Collection debits = new Debit.Collection("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/debits");

}
}

