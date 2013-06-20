% if mode == 'definition':
Account.associateBankAccount(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Account account = new Account();
account.associateBankAccount("/v1/bank_accounts/BA1KawqyAPjlJABtlpNxhatp");

% endif

