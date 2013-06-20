% if mode == 'definition':
Account.associateCard(String uri);

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.associateCard("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC1FuQR6sXB07wmrWwwFF2Wj");

% endif

