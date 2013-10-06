% if mode == 'definition':
Marketplace.credits

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

