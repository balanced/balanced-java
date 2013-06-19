% if mode == 'definition':
Account.credits

% else:
Account account = new Account("/v1/bank_accounts/BA3S82mRZS12C8AkQ8flcYXB");
Credit.Collection credits = account.credits;

% endif

