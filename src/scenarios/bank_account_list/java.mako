% if mode == 'definition':
BankAccount.Collection(String uri)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount.Collection bankAccounts = new BankAccount.Collection(BankAccount.resource_href);

% endif

