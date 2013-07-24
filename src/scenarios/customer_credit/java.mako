% if mode == 'definition':
Customer.credit(int amount,
String description,
String destination_uri,
String appears_on_statement_as,
String debit_uri,
Map<String, String> meta);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Customer customer = new Customer("");
customer.credit(100);

% endif

