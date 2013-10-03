% if mode == 'definition':
BankAccount.unstore()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3Cc1WHeLCM0GhP6havpp7N");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

