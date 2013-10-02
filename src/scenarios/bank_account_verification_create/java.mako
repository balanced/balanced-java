% if mode == 'definition':
BankAccount.verify();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount ba = new BankAccount("/v1/bank_accounts/BA6aAfGRXuglH6NYXi9jrdVR/verifications");
ba.verify();

% endif

