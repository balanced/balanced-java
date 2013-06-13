% if mode == 'definition':
Card card = new Card();

% else:
    Hold hold = new Hold("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/holds/HL3eEBWviWudXZlBXN7FLrTA");
    hold.appears_on_statement_as = "ShowsUpOnStmt";
    hold.description = "Some descriptive text for the debit in the dashboard";
    hold.uri = "/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/holds/HL3eEBWviWudXZlBXN7FLrTA";
    hold.save();

% endif

