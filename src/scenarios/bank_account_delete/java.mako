% if mode == 'definition':
BankAccount.unstore()

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA6nZLdijPKzQ8RhJNnN1OD6");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

