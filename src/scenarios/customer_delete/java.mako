% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("/customers/CU4EeI9UPzRcOo2C3j1qFjQj");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

