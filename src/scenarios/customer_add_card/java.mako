% if mode == 'definition':
Customer.addCard(String uri);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Customer customer = new Customer("/v1/customers/CU6C6w0wYGGwMftYKS6tyCYM");
customer.addCard("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/cards/CC6Dsnkgg9hSvw6wkrn6ylui");

% endif

