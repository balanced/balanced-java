% if mode == 'definition':
Card().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2jJSjIixy2qkOMmIONPtXnawOUftBDRSK");

Card card = new Card("/cards/CC7nMc4BAti7DgvWmpGV5e6N");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");

try {
    Credit credit = card.credit(payload);
}
catch (FundingInstrumentNotCreditable e) {}
catch (HTTPError e) {}

% endif

