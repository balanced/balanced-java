% if mode == 'definition':
Hold.capture();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/holds/HL5YCE1iZRgP2qBoXNADTuCS");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "ShowsUpOnStmt");

hold.capture(payload);

% endif

