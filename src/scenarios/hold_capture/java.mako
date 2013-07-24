% if mode == 'definition':
Hold.capture();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/holds/HL4GvHL5XSQVfl2IORRQmJUO");
hold.appears_on_statement_as = "ShowsUpOnStmt";
hold.description = "Some descriptive text for the debit in the dashboard";
hold.uri = "/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/holds/HL4GvHL5XSQVfl2IORRQmJUO";
hold.save();
hold.capture();

% endif

