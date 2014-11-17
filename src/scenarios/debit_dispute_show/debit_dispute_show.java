package debit_dispute_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_dispute_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Debit debit = new Debit("/debits/WD4xfFIxpeQpeRHm55Qc2xV3");
Dispute dispute = debit.dispute;

}
}

