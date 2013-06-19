% if mode == 'definition':
Card card = new Card();

% else:
Hold hold = new Hold("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/holds/HL51umxLCGI3nF6fimJZt4Nq");
hold.is_void = true;
hold.save();

% endif

