% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Customer customer = new Customer("/customers/CU40AyvBB6ny9u3oelCwyc3C");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

