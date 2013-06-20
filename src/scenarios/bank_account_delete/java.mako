% if mode == 'definition':
BankAccount.delete();

% else:
String apiKey = "2776ea40d92e11e29fe1026ba7cac9da";
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
