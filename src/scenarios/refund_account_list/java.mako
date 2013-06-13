% if mode == 'definition':
    Account.refunds

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/accounts/AC2CcqNuwOGPFi8oaeeVik6y");
    Refund.Collection refunds = account.refunds;

% endif

