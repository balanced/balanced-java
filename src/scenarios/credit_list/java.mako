% if mode == 'definition':
Marketplace.credits;

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

