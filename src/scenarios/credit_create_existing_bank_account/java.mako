% if mode == 'definition':
BankAccount.credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA6wDj2MwJTwkPA4s4rEMq2y");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);

ba.credit(payload);

% endif

