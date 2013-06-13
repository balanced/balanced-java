% if mode == 'definition':
Card card = new Card();

% else:
    Account account = new Account("");
    account.hold( 5000,
                  Some descriptive text for the debit in the dashboard,
                  );
    account.save();

% endif

