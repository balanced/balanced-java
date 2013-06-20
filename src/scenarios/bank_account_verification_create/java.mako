% if mode == 'definition':
BankAccount.verify();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA1mOWnGISRn9236e6tOuDLq/verifications");
ba.verify();

% endif

