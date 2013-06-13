% if mode == 'definition':
Card card = new Card();

% else:
    Hold hold = new Hold("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/holds/HL3hEt8bLti69i3rvYVuQ2WC");
    hold.is_void = true;
    hold.save();

% endif

