% if mode == 'definition':
Debit.refund();

% else:
Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD28XgrtWueKlEm9x1krojCG");
debit.refund();

% endif

