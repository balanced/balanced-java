% if mode == 'definition':
Customer.debit(int amount,
               String description,
               String source_uri,
               String appears_on_statement_as,
               String on_behalf_of_uri,
               Map<String, String> meta);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU4Nb7C4elOK1YDp1SE3XWHC");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

customer.debit(payload);

% endif

