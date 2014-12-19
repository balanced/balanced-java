package settlement_show;

import com.balancedpayments.Balanced;
import com.balancedpayments.Settlement;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;

public class settlement_show {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Settlement settlement = new Settlement("/settlements/ST1VhpiMiUv5BrcvJW2G1RgV");

}
}

