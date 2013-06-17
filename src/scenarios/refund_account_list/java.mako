% if mode == 'definition':
    Account.refunds

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/accounts/CU7GuPv9Y2F8ySwJHuHL0YWq");
    Refund.Collection refunds = account.refunds;

% endif
