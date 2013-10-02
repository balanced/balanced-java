% if mode == 'definition':
Customer.credit(int amount,
String description,
String destination_uri,
String appears_on_statement_as,
String debit_uri,
Map<String, String> meta);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Customer customer = new Customer("/v1/customers/CU3adsU393ZhadbawaoGDwSG");
customer.credit(100);

% endif

