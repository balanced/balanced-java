% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3LVXVgJLrzkmB3vUntKJ6t");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

