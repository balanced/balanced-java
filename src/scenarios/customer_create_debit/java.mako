% if mode == 'definition':
Customer.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
String on_behalf_of_uri,
Map<String, String> meta);

% else:
Customer customer = new Customer("");
customer.debit(100);

% endif

