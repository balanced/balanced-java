% if mode == 'definition':
BankAccount.credit(int amount)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount ba = new BankAccount();
ba.account_number = "9900000005";
ba.name = "Johann Bernoulli";
ba.routing_number = "121000358";
ba.type = "checking";
ba.save();

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 10000);

ba.credit(payload);

% endif

