% if mode == 'definition':
BankAccount.Collection(String uri)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount.Collection bankAccounts = new BankAccount.Collection(BankAccount.resource_href);

% endif

