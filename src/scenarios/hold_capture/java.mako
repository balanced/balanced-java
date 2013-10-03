% if mode == 'definition':
Hold.capture()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Hold hold = new Hold("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/holds/HL5OdsQSWpt521V2AVyf2gzc");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "ShowsUpOnStmt");

hold.capture(payload);

% endif

