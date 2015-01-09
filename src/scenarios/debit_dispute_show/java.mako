% if mode == 'definition':
Debit().dispute

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Debit debit = new Debit("/debits/WD5SwXr9jcCfCmmjTH5MCMFD");
Dispute dispute = debit.dispute;

% endif

