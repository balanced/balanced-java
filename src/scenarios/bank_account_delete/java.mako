% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA65yqzcgV6DIdGkEpk7fI8E");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

