% if mode == 'definition':
BankAccount.delete();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA1dnlguWRMK1SXfh7Jp9WVY");
try {
    bankAccount.delete();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

