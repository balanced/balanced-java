% if mode == 'definition':
BankAccount().credits

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN");
Credit.Collection credits = bankAccount.credits;

% endif

