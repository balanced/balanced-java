HashMap<String, Object> creditPayload = new HashMap<String, Object>();
creditPayload.put("amount",  8000);

try {
    Credit credit = order.creditTo(bankAccount, creditPayload);
}
catch (HTTPError e) {}