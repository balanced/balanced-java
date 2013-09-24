package debit_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class debit_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/debits/WD4VHQo1lWHKRGKQfYYl9CkK");

}
}
