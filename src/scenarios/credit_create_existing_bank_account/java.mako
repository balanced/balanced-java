% if mode == 'definition':
BankAccount.credit(int amount);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1iViFZ5fKWIixl3fpq07Je");
ba.credit(10000);

% endif

