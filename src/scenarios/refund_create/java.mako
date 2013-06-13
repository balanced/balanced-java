% if mode == 'definition':
    Debit.refund()

% else:
    Debit debit = new Debit("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/debits/WD3lDAXDcPpgK8tHFcdXEO2Y");
    debit.refund();

% endif

