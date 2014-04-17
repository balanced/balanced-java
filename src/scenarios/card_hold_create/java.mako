% if mode == 'definition':
CardHold(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Card card = new Card("/cards/CCnjE94RvMPW7RnmLdzIL42");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");

try {
    CardHold cardHold = card.hold(payload);
}
catch (HTTPError e) {}

% endif

