% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Customer customer = new Customer("");
Card card = new Card("/cards/CC4tvKLTKXcBJAgkGvPEW58N");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

