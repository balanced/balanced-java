% if mode == 'definition':
    Debit.refund()

% else:
    Debit debit = new Debit("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/debits/WD7pYB2uXq8QAZvVrvO1l2Oq");
    debit.refund();

% endif

