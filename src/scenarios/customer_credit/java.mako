% if mode == 'definition':
Customer.credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU3pCSyHecPahJL4FKDMThoG");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 100);

customer.credit(payload);

% endif

