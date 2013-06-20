% if mode == 'definition':
Hold.capture();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Hold hold = new Hold("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2iXfavB2OOOYDoegA9gdXq");
hold.appears_on_statement_as = "ShowsUpOnStmt";
hold.description = "Some descriptive text for the debit in the dashboard";
hold.uri = "/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/holds/HL2iXfavB2OOOYDoegA9gdXq";
hold.save();
hold.capture();

% endif

