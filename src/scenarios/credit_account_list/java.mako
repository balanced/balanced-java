% if mode == 'definition':
Credit.Collection credits = new Credit.Collection(String uri);

% else:
Credit.Collection credits = new Credit.Collection("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU/credits");

% endif

