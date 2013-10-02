% if mode == 'definition':
Marketplace.credits;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

