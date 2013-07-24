% if mode == 'definition':
Customer.debit(int amount,
               String description,
               String source_uri,
               String appears_on_statement_as,
               String on_behalf_of_uri,
               Map<String, String> meta);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Customer customer = new Customer("");
customer.debit(100);

% endif

