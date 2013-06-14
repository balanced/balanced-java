% if mode == 'definition':
    Credit.Collection credits = new Credit.Collection()

% else:
        Marketplace mp = Marketplace.mine();
        Credit.Collection credits = mp.credits;

% endif

