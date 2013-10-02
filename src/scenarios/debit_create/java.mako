% if mode == 'definition':
Account.debit(int amount,
              String description,
              String source_uri,
              String appears_on_statement_as,
              Map<String, String> meta);

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Account account = new Account("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC60phFedcLiZvKXFoMGZZ8c");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/accounts/AC60phFedcLiZvKXFoMGZZ8c",
              "Statement text",
              null);

% endif

