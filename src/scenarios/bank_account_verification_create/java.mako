% if mode == 'definition':
BankAccount.verify();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1mOWnGISRn9236e6tOuDLq/verifications");
ba.verify();

% endif

