% if mode == 'definition':
    Account account = new Account(payload);

% else:
    HashMap<String, String> payload = new HashMap<String, String>();
    payload.put("dob", "");
    payload.put("name", "Johann Bernoulli");
    payload.put("phone_number", "");
    payload.put("postal_code", "");
    payload.put("street_address", "");
    payload.put("type", "checking");
    Account account = new Account(payload);

% endif

