% if mode == 'definition':
Customer.addCard(String uri)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU5K29KHV21jnwgxVe2rW5nF");
customer.addCard("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC5LSyXneU8VvRVdq9MSVbh6");

% endif

