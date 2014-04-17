% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4BWUWGpCUSJoo0e9EiFE2");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

