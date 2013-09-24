% if mode == 'definition':
Account.debit(int amount,
              String description,
              String source_uri,
              String appears_on_statement_as,
              Map<String, String> meta);

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("");
account.debit(5000,
              "Some descriptive text for the debit in the dashboard",
              "",
              "Statement text",
              null);

% endif

