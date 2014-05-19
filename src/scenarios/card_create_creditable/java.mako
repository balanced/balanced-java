% if mode == 'definition':
Card(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2jJSjIixy2qkOMmIONPtXnawOUftBDRSK");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "Johannes Bach");
payload.put("number", "4342561111111118");
payload.put("expiration_month", 05);
payload.put("expiration_year", 2020);

Card card = new Card(payload);
try {
    card.save();
}
catch (HTTPError e) {}

% endif

