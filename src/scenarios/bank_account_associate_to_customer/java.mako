% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Customer customer = new Customer("/customers/CU3o1ZAd8Gtxz6ZTIFK9YmsM");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN");

bankAccount.associateToCustomer(customer);

% endif

