% if mode == 'definition':
    Debit.Collection

% else:
    Account account = new Account("");
    Debit.Collection debits = account.debits;

% endif

