package bank_account_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

}
}

