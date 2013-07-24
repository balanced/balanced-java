% if mode == 'definition':
BankAccount.unstore();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3KPriol4oA5MwrDmSR7it0");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

