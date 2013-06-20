% if mode == 'definition':
BankAccount.delete();

% else:
BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA1dnlguWRMK1SXfh7Jp9WVY");
try {
    bankAccount.delete();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

