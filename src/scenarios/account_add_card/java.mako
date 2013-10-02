% if mode == 'definition':
Account.associateCard(String uri);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC60phFedcLiZvKXFoMGZZ8c");
account.associateCard("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/cards/CC6299oguEdSms4dd3PUYrMq");

% endif

