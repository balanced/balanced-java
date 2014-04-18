% if mode == 'definition':
BankAccount().credits

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA8MzVwjVFnkuUvfHaXmqMZ");
Credit.Collection credits = bankAccount.credits;

% endif

