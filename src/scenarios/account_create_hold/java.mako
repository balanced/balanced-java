% if mode == 'definition':
Account.hold(int amount);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC52P298OJQArx1rVOrsVNfG");
Hold hold = account.hold(100);

% endif

