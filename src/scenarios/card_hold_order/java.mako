% if mode == 'definition':
CardHold(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Card card = new Card("/cards/CC48j1De9eVYELLivrgDeCM8");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("order", "/orders/OR5e6wrps4tp9QarDxWa01O5");

try {
    CardHold cardHold = card.hold(payload);
}
catch (HTTPError e) {}

% endif

