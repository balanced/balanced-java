% if mode == 'definition':
Marketplace.credits

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

