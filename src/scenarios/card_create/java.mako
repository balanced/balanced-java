% if mode == 'definition':
Card(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("number", "5105105105105100");
payload.put("expiration_month", 12);
payload.put("expiration_year", 2020);
payload.put("cvv", "123");

Card card = new Card(payload);
try {
    card.save();
}
catch (HTTPError e) {}

% endif

