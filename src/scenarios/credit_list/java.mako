% if mode == 'definition':
Marketplace.credits;

% else:
Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

