% if mode == 'definition':
Debit.Collection

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
Debit.Collection debits = account.debits;

% endif

