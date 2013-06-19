% if mode == 'definition':
Account.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
Map<String, String> meta)

% else:
Account account = new Account("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/accounts/AC4eJoKeEVrjhbE8gnTOBF9M");
account.debit( 5000,
"Some descriptive text for the debit in the dashboard",
"/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/accounts/AC4eJoKeEVrjhbE8gnTOBF9M",
"Statement text",
null);

% endif

