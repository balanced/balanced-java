% if mode == 'definition':
Account.associateCard(String uri);

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.associateCard("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/cards/CC1FuQR6sXB07wmrWwwFF2Wj");

% endif

