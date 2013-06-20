% if mode == 'definition':
Customer.debit(int amount, String holdUri);

% else:
// requires updated scenarios.cache
Customer customer = new Customer("");
customer.debit(100, "");

% endif

