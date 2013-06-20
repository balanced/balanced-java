% if mode == 'definition':
Customer.debits;

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Customer customer = new Customer("");
Debit.Collection debits  = customer.debits;

% endif

