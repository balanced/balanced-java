% if mode == 'definition':
BankAccount.unstore();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA6eH8LiVZfh1Nj1bxiUs4D4");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

