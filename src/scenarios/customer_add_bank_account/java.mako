% if mode == 'definition':
Customer.addBankAccount(String uri)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU7o5OSA8KuFSSjweE54NITe");
customer.addBankAccount("/v1/bank_accounts/BA7q1HxYvJr41fVUPk8vMrCm");

% endif

