% if mode == 'definition':
    Account.associateCard(card_uri);

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/accounts");
    account.associateCard("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/cards/CC6wEPGAzIQmdgiFUO4beyoU");

% endif

