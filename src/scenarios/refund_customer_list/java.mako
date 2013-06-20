% if mode == 'definition':
Customer.refunds;

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Customer customer = new Customer("");
Refund.Collection refunds = customer.refunds;

% endif

