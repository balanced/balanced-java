% if mode == 'definition':
    Account account = new Account(payload);

% else:
    Map<String, Object> payload = new HashMap<String, Object>();
    payload.put("dob", "");
    payload.put("name", "Johann Bernoulli");
    payload.put("phone_number", "");
    payload.put("postal_code", "");
    payload.put("street_address", "");
    payload.put("type", "checking");
    BankAccount account = new BankAccount(payload);

% endif

