% if mode == 'definition':
Debit().refund()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Debit debit = new Debit("/debits/WD57kmfV9Cgc0MiZkHOmFU1z");

try {
    debit.refund();
}
catch (HTTPError e) {}

% endif

