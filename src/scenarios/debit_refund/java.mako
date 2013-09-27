% if mode == 'definition':
Debit.refund();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/debits/WD54TNQNgO0oYMYLFtCmgKdi");
debit.refund();

% endif

