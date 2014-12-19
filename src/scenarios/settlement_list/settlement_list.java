package settlement_list;

import com.balancedpayments.Balanced;
import com.balancedpayments.Settlement;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class settlement_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Settlement.Collection settlements = new Settlement.Collection(Settlement.resource_href);

}
}

