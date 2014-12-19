package settlement_list_account;

import com.balancedpayments.Account;
import com.balancedpayments.Balanced;
import com.balancedpayments.Settlement;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class settlement_list_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Account account = new Account("/accounts/AT43cMKrvwKEJnV5qX8wCqY0");
Settlement.Collection settlements = account.settlements;

}
}

