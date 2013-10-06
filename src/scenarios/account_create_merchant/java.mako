% if mode == 'definition':
Account.associateBankAccount(String uri)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Account account = new Account("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/accounts/CU5U8N8xXdkTgLmmV3wSozLc");
account.associateBankAccount("/v1/bank_accounts/BA61ypiv3pJICo3jQJxGTTUO");

% endif

