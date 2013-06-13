% if mode == 'definition':
    Hold.capture(...)

% else:
    Hold hold = Hold("");
    hold.account_uri = "";
    Account account = hold.getAccount();
    Debit debit = hold.capture();

% endif

