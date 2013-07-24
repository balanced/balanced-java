% if mode == 'definition':
Debit.refund();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/debits/WD4rXHP8qh7WV30ELGTsp9kk");
debit.refund();

% endif

