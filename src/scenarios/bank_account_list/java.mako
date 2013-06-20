% if mode == 'definition':
BankAccount.Collection(String uri);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif
