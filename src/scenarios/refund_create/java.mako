% if mode == 'definition':
Debit.refund();

% else:
Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD2S3Z2JJWKzMvFZccxqZ0C4");
debit.refund();

% endif

