package refund_show;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class refund_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Refund refund = new Refund("/v1/customers/CU5uG18syxNwvFGdbknjZmoo/refunds/RF5DdvCEcpQXCNd6F96mfxC6");

}
}

