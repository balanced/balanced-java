% if mode == 'definition':
Order().creditTo(Card card, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC5OFIKHlTTxx8uysB8woICs");
Order order = new Order("/orders/OR483MoeOnJEXwkxqoPdnDF3");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(card, payload);
}
catch (FundingInstrumentNotCreditable e) {}

% endif

