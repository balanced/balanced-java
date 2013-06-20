% if mode == 'definition':
BankAccount.getVerification();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W");
ba.verification_uri = "/v1/bank_accounts/BA1oRQpLj6VsbSYZydExip2W/verifications/BZ1pLd7LVozj3BXOjejENvbi";
BankAccountVerification verification = ba.getVerification();

% endif

