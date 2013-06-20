% if mode == 'definition':
BankAccount bankAccount = new BankAccount(Map<String, Object> payload);

% else:
Map<String, Object> payload = new HashMap<String, Object>();
payload.put("account_number", "9900000001");
payload.put("name", "Johann Bernoulli");
payload.put("routing_number", "121000358");
payload.put("type", "checking");

BankAccount bankAccount = new BankAccount(payload);

% endif

