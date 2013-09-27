package bank_account_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

}
}

