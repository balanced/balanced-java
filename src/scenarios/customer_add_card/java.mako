% if mode == 'definition':
Customer.addCard(String uri)

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Customer customer = new Customer("/v1/customers/CU12eUdTk8OgEj7VbJVFeP0q");
customer.addCard("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/cards/CC15RAm6JJIEIae6bicvlWRw");

% endif

