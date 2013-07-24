% if mode == 'definition':
BankAccount.verify();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA3GC4aCNUVw7WmNSOaDifmw/verifications");
ba.verify();

% endif

