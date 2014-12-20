package debit_dispute_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_dispute_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Debit debit = new Debit("/debits/WD6NY7W6uBFngNyBLqyhPBPv");
Dispute dispute = debit.dispute;

}
}

