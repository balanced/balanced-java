% if mode == 'definition':
Customer().unstore()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU5AxbQrjAcjsbquafnvwaas");

try {
    customer.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

