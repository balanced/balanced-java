HashMap<String, Object> debitPayload = new HashMap<String, Object>();
debitPayload.put("amount", 10000);

try {
    Debit debit = order.debitFrom(card, debitPayload);
}
catch (HTTPError e) {}