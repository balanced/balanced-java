% if mode == 'definition':
Account.hold(int amount,
             String description,
             String source_uri,
             Map<String, String> meta)

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Account account = new Account("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/accounts/AC3wBjegN7PnQ8lPOQSkLoJx");
account.hold(5000,
             "Some descriptive text for the debit in the dashboard",
             "",
             null);
account.save();

% endif

