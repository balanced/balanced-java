package debit_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Debit.Collection debits = new Debit.Collection("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/debits");

}
}

