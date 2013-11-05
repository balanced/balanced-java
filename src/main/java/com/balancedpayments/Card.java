package com.balancedpayments;

import java.util.HashMap;
import java.util.Map;

import com.balancedpayments.core.ResourceCollection;
import com.balancedpayments.core.ResourceField;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.MultipleResultsFound;
import com.balancedpayments.errors.NoResultsFound;
import com.balancedpayments.errors.NotCreated;

public class Card extends FundingInstrument {

    @ResourceField(mutable=true)
    public String card_number;

    @ResourceField(mutable=true)
    public Integer expiration_year;

    @ResourceField(mutable=true)
    public Integer expiration_month;

    @ResourceField(mutable=true, required=false)
    public String security_code;

    @ResourceField(mutable=true)
    public String name;

    @ResourceField(mutable=true)
    public String phone_number;

    @ResourceField(mutable=true)
    public String city;

    @ResourceField(mutable=true)
    public String region;

    @ResourceField(mutable=true)
    public String state;

    @ResourceField(mutable=true)
    public String postal_code;

    @ResourceField(mutable=true)
    public String street_address;

    @ResourceField(mutable=true)
    public String country_code;

    @ResourceField(mutable=true)
    public Map<String, Object> meta;

    @ResourceField(field="hash")
    public String fingerprint;

    @ResourceField()
    public String last_four;

    @ResourceField()
    public String card_type;

    @ResourceField()
    public String brand;

    @ResourceField()
    public Boolean is_valid;

    @ResourceField()
    public Boolean is_verified;

    @ResourceField()
    public String postal_code_check;

    @ResourceField()
    public String security_code_check;

    @ResourceField(required=false)
    public String customer_uri;


    public static class Collection extends ResourceCollection<Card> {
        public Collection(String uri) {
            super(Card.class, uri);
        }

        @Override
        public Card create(Map<String, Object> payload) throws HTTPError {
            return super.create(payload);
        }

        public Card create(
                String card_number,
                int expiration_month,
                int expiration_year) throws HTTPError {
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("card_number", card_number);
            payload.put("expiration_month", expiration_month);
            payload.put("expiration_year", expiration_year);
            return super.create(payload);
        }
    }

    public static Card get(String uri) throws HTTPError {
        return new Card((Balanced.getInstance().getClient()).get(uri));
    }

    public Card() {
        super();
    }

    public Card (Object obj) throws HTTPError{
        super(obj);
    }

    @Override
    public void save() throws HTTPError {
        // Needs marketplace endpoint here.
        // Ignore MultipleResultsFound and NoResultsFound exceptions
        try {
            if (id == null && uri == null)
                uri = String.format("/v%s/marketplaces/%s/%s",
                        Balanced.getInstance().getAPIVersion(),
                        Marketplace.mine().id,
                        "cards");
            super.save();
        }
        catch (NoResultsFound e) {}
        catch (MultipleResultsFound e) {}
    }
}
