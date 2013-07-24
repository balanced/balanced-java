% if mode == 'definition':
Customer.addBankAccount(String uri);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Customer customer = new Customer("/v1/customers/CU4gcjFrOmH4zhTwvSmGp6pN");
customer.addBankAccount("/v1/bank_accounts/BA4huHM1UCGSvy3ycQ74fleW");

% endif

