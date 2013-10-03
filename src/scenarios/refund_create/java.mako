% if mode == 'definition':
Debit.refund()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Debit debit = new Debit("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/debits/WD5oAoFKm0K1oHppoKJW2WGy");
debit.refund();

% endif

