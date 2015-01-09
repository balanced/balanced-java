% if mode == 'definition':
Account().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Account account = new Account("/accounts/AT2E6Ju62P9AnTJwe0fL5kOI");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("appears_on_statement_as", "ThingsCo");
payload.put("description", A simple credit);
payload.put("order", "/orders/OR2JfBYxYlDAF3L48u9DtIEU");

try {
    Credit credit = account.credit(payload);
}
catch (HTTPError e) {}

% endif
