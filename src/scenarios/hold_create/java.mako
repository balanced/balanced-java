% if mode == 'definition':
Hold(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU5K29KHV21jnwgxVe2rW5nF");
customer.addCard("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC5LSyXneU8VvRVdq9MSVbh6");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("source_uri", "/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC5LSyXneU8VvRVdq9MSVbh6");

Hold hold = new Hold(payload);
hold.save();

% endif

