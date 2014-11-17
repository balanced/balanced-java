% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA1D19WqGc3j78IAhFIkasQd");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

