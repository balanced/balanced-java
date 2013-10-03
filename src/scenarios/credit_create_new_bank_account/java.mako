% if mode == 'definition':
BankAccount.credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Map<String, Object> bankAccountPayload = new HashMap<String, Object>();
bankAccountPayload.put("name", "Johann Bernoulli");
bankAccountPayload.put("routing_number", "121000358");
bankAccountPayload.put("account_number", "9900000001");
bankAccountPayload.put("type", "checking");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 10000);
payload.put("bank_account", bankAccountPayload);

Credit credit = new Credit(payload);
credit.save();

% endif

