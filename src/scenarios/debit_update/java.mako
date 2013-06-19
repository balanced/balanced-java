% if mode == 'definition':
Card card = new Card();

% else:
Debit debit = new Debit("/v1/marketplaces/TEST-MP3MuCwscFiUbhv2Z2lB49cQ/debits/WD4CibbpNabnO30nPcjmqxwQ");
debit.description = "New description for debit";
Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");
debit.meta = meta;
debit.save();

% endif

