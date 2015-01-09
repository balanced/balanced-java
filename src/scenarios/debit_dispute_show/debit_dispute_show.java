package debit_dispute_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_dispute_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Debit debit = new Debit("/debits/WD5SwXr9jcCfCmmjTH5MCMFD");
Dispute dispute = debit.dispute;

}
}

