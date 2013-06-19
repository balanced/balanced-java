% if mode == 'definition':
Customer.credits

% else:
Customer customer = new Customer("/v1/customers/CU6PXyMacKRYKNJPJFKtONK0");
Credit.Collection credits = customer.credits;

% endif

