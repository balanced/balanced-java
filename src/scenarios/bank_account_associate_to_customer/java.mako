% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Customer customer = new Customer("/customers/CUb38G1IRIovbbaJlMMKUqG");
BankAccount bankAccount = new BankAccount("/bank_accounts/BAd2UKqX83C1p7fhmMx5pmW");

bankAccount.associateToCustomer(customer);

% endif

