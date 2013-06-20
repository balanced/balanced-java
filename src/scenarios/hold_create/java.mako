% if mode == 'definition':
Account.hold(
    int amount,
    String description,
    String source_uri,
    Map<String, String> meta)

% else:
Account account = new Account("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/accounts/AC1DOd9xMVGdZSGUeyrducwU");
account.hold( 5000,
"Some descriptive text for the debit in the dashboard",
"",
null);
account.save();

% endif

