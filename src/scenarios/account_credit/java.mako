% if mode == 'definition':
Account().credit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Account account = new Account("/accounts/AT43cMKrvwKEJnV5qX8wCqY0");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("appears_on_statement_as", "ThingsCo");
payload.put("description", "A simple credit");
payload.put("order", "/orders/OR483MoeOnJEXwkxqoPdnDF3");

try {
    Credit credit = account.credit(payload);
}
catch (HTTPError e) {}

% endif

