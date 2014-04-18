% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Customer customer = new Customer("/customers/CUeXNjpejPooRtSnJLc6SRD");
BankAccount bankAccount = new BankAccount("/bank_accounts/BAscOV2erMwv3yhIb5sFTaV");

bankAccount.associateToCustomer(customer);

% endif

