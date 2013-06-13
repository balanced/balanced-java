% if mode == 'definition':
    Account.refunds

% else:
    Account account = new Account("");
    Refund.Collection refunds = account.refunds;

% endif

