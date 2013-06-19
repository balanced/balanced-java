% if mode == 'definition':
Account.refunds

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
Refund.Collection refunds = account.refunds;

% endif

