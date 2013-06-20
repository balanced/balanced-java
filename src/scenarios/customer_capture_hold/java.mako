% if mode == 'definition':
Customer.debit(int amount, String holdUri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

// requires updated scenarios.cache
Customer customer = new Customer("");
customer.debit(100, "");

% endif

