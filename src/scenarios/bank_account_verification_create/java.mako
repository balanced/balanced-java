% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA17zYxBNrmg9isvicjz9Ae4");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

