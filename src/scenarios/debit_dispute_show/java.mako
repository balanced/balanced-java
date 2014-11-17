% if mode == 'definition':
Debit().dispute

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Debit debit = new Debit("/debits/WD4xfFIxpeQpeRHm55Qc2xV3");
Dispute dispute = debit.dispute;

% endif

