% if mode == 'definition':
Card card = new Card();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/holds/HL4Y57E5vu5hmyiS1XljawTt");
hold.appears_on_statement_as = "ShowsUpOnStmt";
hold.description = "Some descriptive text for the debit in the dashboard";
hold.uri = "/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/holds/HL4Y57E5vu5hmyiS1XljawTt";
hold.save();

% endif

