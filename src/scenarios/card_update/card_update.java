package card_update;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class card_update {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Card card = new Card("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC4bOqdUBsBenWu7klU6Qfzq");
Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

card.meta = meta;
card.save();


}
}
