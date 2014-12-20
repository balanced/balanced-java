% if mode == 'definition':
CardHold(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC47wPIfNkploi0BbLRDqEYo");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("order", "/orders/OR483MoeOnJEXwkxqoPdnDF3");

try {
    CardHold cardHold = card.hold(payload);
}
catch (HTTPError e) {}

% endif

