% if mode == 'definition':
Account().settle(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Account account = new Account("/accounts/AT43cMKrvwKEJnV5qX8wCqY0");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("funding_instrument", /bank_accounts/BA4UZsYXpf2BX97v5WPaT57O);
payload.put("appears_on_statement_as", ThingsCo);
payload.put("description", );

try {
    Settlement settlement = account.settle(payload);
}
catch (HTTPError e) {}

% endif

