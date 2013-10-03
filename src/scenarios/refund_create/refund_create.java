package refund_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Debit debit = new Debit("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/debits/WD5oAoFKm0K1oHppoKJW2WGy");
debit.refund();

}
}

