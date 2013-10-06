% if mode == 'definition':
BankAccount.credits

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount bankAccount = new BankAccount("/v1/bank_accounts/BA6wDj2MwJTwkPA4s4rEMq2y");
Credit.Collection credits = bankAccount.credits;

% endif

