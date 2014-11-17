% if mode == 'definition':
Card().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC3iCCIHprJu5HPyP7vmE92B");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");

try {
    Credit credit = card.credit(payload);
}
catch (FundingInstrumentNotCreditable e) {}
catch (HTTPError e) {}

% endif

