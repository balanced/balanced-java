% if mode == 'definition':
Customer.credit(int amount,
String description,
String destination_uri,
String appears_on_statement_as,
String debit_uri,
Map<String, String> meta);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Customer customer = new Customer("/v1/customers/CU3QbHVO44v9opCiSdarCV14");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 100);

customer.credit(payload);

% endif

