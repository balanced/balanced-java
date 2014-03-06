% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Customer customer = new Customer("/customers/CU4EeI9UPzRcOo2C3j1qFjQj");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA4JCiiAb4alhWMlZSv9POAU");

bankAccount.associateToCustomer(customer);

% endif

