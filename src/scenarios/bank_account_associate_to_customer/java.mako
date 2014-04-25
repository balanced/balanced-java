% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-22IOkhevjZlmRP2do6CZixkkDshTiOjTV");

Customer customer = new Customer("/customers/CU3VYCUIfwngJsidJWdGw2W5");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA3Y63fK5STwlhKNMkE3Utmd");

bankAccount.associateToCustomer(customer);

% endif

