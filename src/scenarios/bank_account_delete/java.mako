% if mode == 'definition':
BankAccount.delete();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA1dnlguWRMK1SXfh7Jp9WVY");
try {
    bankAccount.delete();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

