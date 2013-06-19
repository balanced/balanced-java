% if mode == 'definition':
Account.associateCard(card_uri);

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts");
account.associateCard("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC3xtFSDTQORjXEFMTgP4HWu");

% endif

