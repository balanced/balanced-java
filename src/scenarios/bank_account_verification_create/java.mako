% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3EMnkybAfEzVlbVquXFLEk");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

