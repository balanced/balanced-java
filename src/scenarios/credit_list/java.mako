% if mode == 'definition':
Marketplace.credits;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Marketplace mp = Marketplace.mine();
Credit.Collection credits = mp.credits;

% endif

