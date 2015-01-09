% if mode == 'definition':
CardHold(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC3vhL91rWtwtHcOBl0ITshG");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("order", "/orders/OR3vURGwVtqDnnkRS9fgH41G");

try {
    CardHold cardHold = card.hold(payload);
}
catch (HTTPError e) {}

% endif

