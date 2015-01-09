% if mode == 'definition':
Account().settlements

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Account account = new Account("/accounts/AT3ogJE07IErLJYR510QO6sM");
Settlement.Collection settlements = account.settlements;

% endif

