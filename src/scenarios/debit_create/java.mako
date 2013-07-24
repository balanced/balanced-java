% if mode == 'definition':
Account.debit(int amount,
              String description,
              String source_uri,
              String appears_on_statement_as,
              Map<String, String> meta);

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC3wBjegN7PnQ8lPOQSkLoJx");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC3wBjegN7PnQ8lPOQSkLoJx",
              "Statement text",
              null);

% endif

