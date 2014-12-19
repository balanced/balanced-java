% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Customer customer = new Customer("/customers/CU42QGL6X08UHbQnRqgCNtKg");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA4UZsYXpf2BX97v5WPaT57O");

bankAccount.associateToCustomer(customer);

% endif

