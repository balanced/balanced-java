% if mode == 'definition':
Card().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Customer customer = new Customer("");
Card card = new Card("/cards/CCVkCgaysaNhZH3ITVLmQ9X");

try {
    card.associateToCustomer(customer);
}
catch (HTTPError e) {}

% endif

