% if mode == 'definition':
Order().creditTo(Card card, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC4HDcgvzIltvwv6GSjBVbji");
Order order = new Order("/orders/OR3vURGwVtqDnnkRS9fgH41G");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Credit credit = order.creditTo(card, payload);
}
catch (FundingInstrumentNotCreditable e) {}

% endif

