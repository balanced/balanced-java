% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Customer customer = new Customer("");
Card card = new Card("/cards/CC5OFIKHlTTxx8uysB8woICs");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

