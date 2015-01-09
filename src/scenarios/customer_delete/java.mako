% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Customer customer = new Customer("/customers/CU3MjqyarSxE66kggE8MMtGB");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

