% if mode == 'definition':
    Account.credits

% else:
    Account account = new Account("/v1/bank_accounts/BA2fU4b0MNuBHuI3NrvyOsTE");
    Credit.Collection credits = account.credits;

% endif

