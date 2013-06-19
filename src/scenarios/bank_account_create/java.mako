% if mode == 'definition':
Account account = new Account(payload);

% else:
Map<String, Object> payload = new HashMap<String, Object>();
payload.put("account_number", "9900000001");
payload.put("name", "Johann Bernoulli");
payload.put("routing_number", "121000358");
payload.put("type", "checking");

BankAccount account = new BankAccount(payload);

% endif

