% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA8MzVwjVFnkuUvfHaXmqMZ");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

