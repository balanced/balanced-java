% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4plzFRTGgaoZftGcIJH3Py");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

