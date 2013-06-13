% if mode == 'definition':
Card card = new Card();

% else:
    Hold hold = new Hold("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/holds/HL7iwVbB1X6aMBuW6J2rKJfg");
    hold.appears_on_statement_as = "ShowsUpOnStmt";
    hold.description = "Some descriptive text for the debit in the dashboard";
    hold.uri = "/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/holds/HL7iwVbB1X6aMBuW6J2rKJfg";
    hold.save();

% endif

