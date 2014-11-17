% if mode == 'definition':
BankAccount(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("account_number", "9900000001");
payload.put("name", "Johann Bernoulli");
payload.put("routing_number", "121000358");
payload.put("account_type", "checking");

BankAccount bankAccount = new BankAccount(payload);
try {
    bankAccount.save();
}
catch (HTTPError e) {}

% endif

