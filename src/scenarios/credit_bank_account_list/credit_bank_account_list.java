package credit_bank_account_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_bank_account_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("/v1/bank_accounts/BA43YHYoNLyuUUJ0VjZpKBpd");
Credit.Collection credits = account.credits;

}
}
