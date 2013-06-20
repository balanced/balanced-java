% if mode == 'definition':
BankAccount.Collection(String uri);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount.Collection bankAccounts = new BankAccount.Collection("/v1/bank_accounts");

% endif

