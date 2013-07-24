% if mode == 'definition':
Account.debits;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC3wBjegN7PnQ8lPOQSkLoJx");
Debit.Collection debits = account.debits;

% endif

