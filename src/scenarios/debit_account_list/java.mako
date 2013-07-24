% if mode == 'definition':
Account.debits;

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC60phFedcLiZvKXFoMGZZ8c");
Debit.Collection debits = account.debits;

% endif

