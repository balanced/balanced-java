% if mode == 'definition':
Customer.addBankAccount(String uri)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Customer customer = new Customer("/v1/customers/CU4lgbQNfVGHYdW92fsHu9z8");
customer.addBankAccount("/v1/bank_accounts/BA4mVwPx6PesFr2ep0CUbEHS");

% endif

