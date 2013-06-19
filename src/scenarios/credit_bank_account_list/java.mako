% if mode == 'definition':
Account.credits

% else:
Account account = new Account("/v1/bank_accounts/BA1iViFZ5fKWIixl3fpq07Je");
Credit.Collection credits = account.credits;

% endif

