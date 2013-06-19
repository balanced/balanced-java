% if mode == 'definition':
Account.associateCard(card_uri);

% else:
Account account = new Account("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/accounts");
account.associateCard("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/cards/CC5STBKsco3SO9t9VbUsp6Lu");

% endif

