% if mode == 'definition':
BankAccount.credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3GU9eoZ5YrnVZWPtmfZrNt");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);

ba.credit(payload);

% endif

