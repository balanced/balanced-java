% if mode == 'definition':
Hold.save()

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/holds/HL4PZ8SD1lhzujO5Ksixaeti");
hold.description = "update this description";
hold.save();

% endif

