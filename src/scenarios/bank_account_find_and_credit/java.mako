% if mode == 'definition':
BankAccount.credit(int amount);

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3cqPyNcF9b8JU3BRoLjZn8");
//ba.credit(1000);

% endif

