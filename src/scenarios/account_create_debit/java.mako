% if mode == 'definition':
Account.debit(int amount);

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC3z3msdgTHiowL349h94P22");
account.debit(100);

% endif

