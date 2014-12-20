package order_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class order_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Order order = new Order("/orders/OR1ugPYIQ94wAaS439i25QVL");

Map<String, String> meta = new HashMap<String, String>();
meta.put("product.id", "1234567890");
meta.put("anykey", "valuegoeshere");

order.meta = meta;
order.description = "New description for order";

try {
    order.save();
}
catch (HTTPError e) {}

}
}

