% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA7JTM3gXtLHz4juPfeQ4oqz");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

