% if mode == 'definition':
Account().settlements

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Account account = new Account("/accounts/AT43cMKrvwKEJnV5qX8wCqY0");
Settlement.Collection settlements = account.settlements;

% endif

