% if mode == 'definition':
Customer.unstore();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer();

try {
    customer.unstore();
}
catch (NotCreated e) {
    // the customer didn't exist in the first place
}

% endif

