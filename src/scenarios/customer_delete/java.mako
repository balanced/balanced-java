% if mode == 'definition':
Customer.unstore()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4pU7o8tYkqaGTvf1UQXAFG");

try {
    customer.unstore();
}
catch (NotCreated e) {
    // the customer didn't exist in the first place
}

% endif

