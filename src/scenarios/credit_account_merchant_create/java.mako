% if mode == 'definition':
    Account.credit(amount)

% else:
    Account account = new Account("");
    account.credit(100);

% endif

