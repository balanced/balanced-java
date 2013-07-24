% if mode == 'definition':
Account.associateCard(String uri);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts");
account.associateCard("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/cards/CC52unXOdJdpm34QF3XxoV7a");

% endif

