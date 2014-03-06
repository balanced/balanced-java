% if mode == 'definition':
BankAccount().unstore()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA3LBmizwthrjehivn2ffzHU");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

% endif

