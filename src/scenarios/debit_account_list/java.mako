% if mode == 'definition':
Account.debits;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("");
Debit.Collection debits = account.debits;

% endif

