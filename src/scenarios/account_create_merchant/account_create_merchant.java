package account_create_merchant;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class account_create_merchant {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account();
account.associateBankAccount("/v1/bank_accounts/BA3IWyTlENYQYJQVWQLq5qwq");

}
}
