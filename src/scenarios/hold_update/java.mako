% if mode == 'definition':
Hold.save()

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/holds/HL7bjNLGObnfJJhcKdOjTon5");
hold.description = "update this description";
hold.save();

% endif

