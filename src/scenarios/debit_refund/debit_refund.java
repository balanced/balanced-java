package debit_refund;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_refund {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Debit debit = new Debit("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/debits/WD4Oy9fzO68lQrGs7I05OPpe");
debit.refund();

}
}

