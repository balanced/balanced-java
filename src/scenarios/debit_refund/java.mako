% if mode == 'definition':
Debit.refund();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD28XgrtWueKlEm9x1krojCG");
debit.refund();

% endif

