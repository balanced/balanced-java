% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Customer customer = new Customer("/customers/CU1eX3FIMntmCLmi2VfWA2db");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

