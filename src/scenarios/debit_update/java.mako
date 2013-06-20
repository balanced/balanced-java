% if mode == 'definition':
Debit.save();

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD226COgRPON3b8joB90ti2I");
debit.description = "New description for debit";
Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");
debit.meta = meta;
debit.save();

% endif

