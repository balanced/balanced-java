package credit_create_existing_bank_account;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class credit_create_existing_bank_account {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA43YHYoNLyuUUJ0VjZpKBpd");
ba.credit(10000);

}
}
