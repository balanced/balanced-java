% if mode == 'definition':
Debit().dispute

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Debit debit = new Debit("/debits/WD4QE0i532v0eWQ6mCWCASc5");
Dispute dispute = debit.dispute;

% endif

