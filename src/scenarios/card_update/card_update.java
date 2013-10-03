package card_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Card card = new Card("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC3Nm7MZZgDfqOKGyZ5cu9eM");
Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

card.meta = meta;
card.save();


}
}

