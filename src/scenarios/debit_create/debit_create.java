package debit_create;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_create {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "",
              "Statement text",
              null);

}
}
