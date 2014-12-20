% if mode == 'definition':
Debit().dispute

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Debit debit = new Debit("/debits/WD6NY7W6uBFngNyBLqyhPBPv");
Dispute dispute = debit.dispute;

% endif

