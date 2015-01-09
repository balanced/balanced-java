% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("");
Card card = new Card("/cards/CC4HDcgvzIltvwv6GSjBVbji");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

