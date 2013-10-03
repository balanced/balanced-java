% if mode == 'definition':
Customer.holds

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4YcokzpBw7L1Fluc0gPVAA");
Hold.Collection holds = customer.holds;

% endif

