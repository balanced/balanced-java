% if mode == 'definition':
BankAccount().verify()

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3IhKG3bIN22cLHbaOIGtHb");
try {
    bankAccount.verify();
}
catch (HTTPError e) {}

% endif

