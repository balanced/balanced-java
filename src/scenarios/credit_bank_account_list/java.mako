% if mode == 'definition':
    Account.credits

% else:
    Account account = new Account("/v1/bank_accounts/BA6aflmsJEE7FldgQGpsgW0u");
    Credit.Collection credits = account.credits;

% endif

