% if mode == 'definition':
Debit.refund();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Debit debit = new Debit("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/debits/WD7elkB2x5Kj09uFxSd5rmB2");
debit.refund();

% endif

