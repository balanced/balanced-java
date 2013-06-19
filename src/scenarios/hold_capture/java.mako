% if mode == 'definition':
Card card = new Card();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2iXfavB2OOOYDoegA9gdXq");
hold.appears_on_statement_as = "ShowsUpOnStmt";
hold.description = "Some descriptive text for the debit in the dashboard";
hold.uri = "/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2iXfavB2OOOYDoegA9gdXq";
hold.save();

% endif

