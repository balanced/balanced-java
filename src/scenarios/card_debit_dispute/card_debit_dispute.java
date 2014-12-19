package card_debit_dispute;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_debit_dispute {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC6NqHMgvYPDq4zOrvsZceJO");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "Statement text");

try {
    Debit debit = card.debit(payload);
}
catch (HTTPError e) {}

}
}

