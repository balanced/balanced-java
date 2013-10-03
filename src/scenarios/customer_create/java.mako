% if mode == 'definition':
Customer()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("name", "William Henry Cavendish III");
payload.put("email", "william@example.com");

Customer customer = new Customer(payload);
customer.save();

% endif

