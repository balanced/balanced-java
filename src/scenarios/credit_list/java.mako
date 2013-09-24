% if mode == 'definition':
Marketplace.credits;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

