% if mode == 'definition':
BankAccount.unstore();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA3YXRiVoKoMJMhq3Bfwxyu2");
try {
    bankAccount.unstore();
}
catch (NotCreated e) {
    // the bank account didn't exist in the first place
}

% endif

