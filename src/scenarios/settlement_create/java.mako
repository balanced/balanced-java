% if mode == 'definition':
Account().settle(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Account account = new Account("/accounts/AT3ogJE07IErLJYR510QO6sM");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("funding_instrument", "/bank_accounts/BA45anEaEr8g0lOhzhcE9VAN");
payload.put("appears_on_statement_as", "ThingsCo");
payload.put("description", "Payout A");

try {
    Settlement settlement = account.settle(payload);
}
catch (HTTPError e) {}

% endif

