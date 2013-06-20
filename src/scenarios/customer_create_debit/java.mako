% if mode == 'definition':
Customer.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
String on_behalf_of_uri,
Map<String, String> meta);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Customer customer = new Customer("");
customer.debit(100);

% endif

