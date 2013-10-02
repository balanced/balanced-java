% if mode == 'definition':
Debit.save();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Debit debit = new Debit("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/debits/WD6JxwogDY2GjlaUCGqdNfNK");
debit.description = "New description for debit";
Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");
debit.meta = meta;
debit.save();

% endif

