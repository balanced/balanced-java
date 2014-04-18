% if mode == 'definition':
BankAccount.Collection(String uri)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

BankAccount.Collection bankAccounts = new BankAccount.Collection(BankAccount.resource_href);

% endif

