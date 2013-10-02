% if mode == 'definition':
Account.hold(int amount,
             String description,
             String source_uri,
             Map<String, String> meta)

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC60phFedcLiZvKXFoMGZZ8c");
account.hold(5000,
             "Some descriptive text for the debit in the dashboard",
             "",
             null);
account.save();

% endif

