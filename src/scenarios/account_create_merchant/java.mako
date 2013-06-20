% if mode == 'definition':
Account.associateBankAccount(String uri);

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account();
account.associateBankAccount("/v1/bank_accounts/BA1KawqyAPjlJABtlpNxhatp");

% endif
