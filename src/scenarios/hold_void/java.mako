% if mode == 'definition':
Card card = new Card();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/holds/HL7mo97WlNDLH601wVhD3VTI");
hold.is_void = true;
hold.save();

% endif

