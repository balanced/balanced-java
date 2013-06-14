% if mode == 'definition':
  Customer.debit(int amount,
                 String description,
                 String source_uri,
                 String appears_on_statement_as,
                 String on_behalf_of_uri,
                 Map<String, String> meta)

% else:
    Customer customer = new Customer("/v1/customers/CU7GuPv9Y2F8ySwJHuHL0YWq");
    customer.debit( 1000);

% endif

