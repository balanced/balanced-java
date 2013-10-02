% if mode == 'definition':
Hold.capture();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Hold hold = new Hold("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/holds/HL77tz3pu9U1ZfLggZgYijEW");
hold.appears_on_statement_as = "ShowsUpOnStmt";
hold.description = "Some descriptive text for the debit in the dashboard";
hold.uri = "/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/holds/HL77tz3pu9U1ZfLggZgYijEW";
hold.save();
hold.capture();

% endif

