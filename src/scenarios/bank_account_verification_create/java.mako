% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount bankAccount = new BankAccount("/bank_accounts/BAcRGk40xmI8meZpNLB3oYp");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

