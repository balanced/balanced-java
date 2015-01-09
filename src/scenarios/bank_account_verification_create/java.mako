% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3uzbngfVXy1SGg25Et7iKY");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

