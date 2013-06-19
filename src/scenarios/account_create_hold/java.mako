% if mode == 'definition':
Account.hold(...)

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC3z3msdgTHiowL349h94P22");
Hold hold = account.hold(100);

% endif

