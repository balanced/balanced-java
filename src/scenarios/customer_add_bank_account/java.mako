% if mode == 'definition':
Customer.addBankAccount(String uri);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Customer customer = new Customer("/v1/customers/CU3adsU393ZhadbawaoGDwSG");
customer.addBankAccount("/v1/bank_accounts/BA3cqPyNcF9b8JU3BRoLjZn8");

% endif

