% if mode == 'definition':
Debit.refund()

% else:
Debit debit = new Debit("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/debits/WD55wEPOn0aq6Y4YcuSN1GXw");
debit.refund();

% endif

