% if mode == 'definition':
BankAccount.verify();

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1mOWnGISRn9236e6tOuDLq/verifications");
ba.verify();

% endif
