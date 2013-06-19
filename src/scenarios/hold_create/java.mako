% if mode == 'definition':
Card card = new Card();

% else:
Account account = new Account("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/accounts/AC4eJoKeEVrjhbE8gnTOBF9M");
account.hold( 5000,
"Some descriptive text for the debit in the dashboard",
"",
null);
account.save();

% endif

