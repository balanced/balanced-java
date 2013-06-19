% if mode == 'definition':
Account.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
Map<String, String> meta)

% else:
Account account = new Account("");
account.debit( 5000,
"Some descriptive text for the debit in the dashboard",
"",
"Statement text",
null);

% endif

