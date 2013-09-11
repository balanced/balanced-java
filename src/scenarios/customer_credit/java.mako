% if mode == 'definition':
Customer.credit(int amount,
String description,
String destination_uri,
String appears_on_statement_as,
String debit_uri,
Map<String, String> meta);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Customer customer = new Customer("/v1/customers/CU3adsU393ZhadbawaoGDwSG");
customer.credit(100);

% endif

