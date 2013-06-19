% if mode == 'definition':
Customer.credit(int amount,
String description,
String destination_uri,
String appears_on_statement_as,
String debit_uri,
Map<String, String> meta)

% else:
Customer customer = new Customer("/v1/customers/CU6PXyMacKRYKNJPJFKtONK0");
customer.credit(100);

% endif

