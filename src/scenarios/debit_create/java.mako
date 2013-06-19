% if mode == 'definition':
Account.debit(int amount,
String description,
String source_uri,
String appears_on_statement_as,
Map<String, String> meta)

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.debit( 5000,
"Some descriptive text for the debit in the dashboard",
"/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU",
"Statement text",
null);

% endif

