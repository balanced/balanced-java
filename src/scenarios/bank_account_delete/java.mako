% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4GVxlUHmn8y0CjAUEcW6Kp");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

