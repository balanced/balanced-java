% if mode == 'definition':
    Hold.capture(...)

% else:
    Hold hold = new Hold("");
    hold.account_uri = "";
    Account account = hold.getAccount();
    Debit debit = hold.capture();

% endif

