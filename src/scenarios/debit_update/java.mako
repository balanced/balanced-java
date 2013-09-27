% if mode == 'definition':
Debit.save();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/debits/WD4VHQo1lWHKRGKQfYYl9CkK");
debit.description = "New description for debit";

Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");

debit.meta = meta;
debit.save();

% endif

