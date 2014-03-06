% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("");
Card card = new Card("/cards/CC4GOYzOKyWXBzJMVTs00aNk");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

