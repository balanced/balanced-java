% if mode == 'definition':
Customer.unstore()

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU7tcMPhFkoiaOjRkmmdBhXO");

try {
    customer.unstore();
}
catch (NotCreated e) {
    // the customer didn't exist in the first place
}

% endif

