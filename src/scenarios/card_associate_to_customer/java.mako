% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Customer customer = new Customer("");
Card card = new Card("/cards/CC3bspNmYxyJu9J52MbgArDy");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

