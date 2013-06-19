% if mode == 'definition':
Card card = new Card();

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.hold( 5000,
"Some descriptive text for the debit in the dashboard",
"",
null);
account.save();

% endif

