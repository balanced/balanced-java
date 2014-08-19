Map<String, Object> buyerPayload = new HashMap<String, Object>();
buyerPayload.put("name", "John Buyer");

Customer buyer = new Customer(buyerPayload);

try {
    buyer.save();
}
catch (HTTPError e) {}

Map<String, Object> cardPayload = new HashMap<String, Object>();
cardPayload.put("number", "5105105105105100");
cardPayload.put("expiration_month", 12);
cardPayload.put("expiration_year", 2020);
cardPayload.put("cvv", "123");

Card card = new Card(cardPayload);
try {
    card.save();
    card.associateToCustomer(buyer);
}
catch (HTTPError e) {}
