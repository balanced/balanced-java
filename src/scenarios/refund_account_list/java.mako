% if mode == 'definition':
Account.refunds;

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("");
Refund.Collection refunds = account.refunds;

% endif

