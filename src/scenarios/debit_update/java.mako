% if mode == 'definition':
Debit.save();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Debit debit = new Debit("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/debits/WD4kiFCRCuX81uHcFaIqBFAr");
debit.description = "New description for debit";
Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");
debit.meta = meta;
debit.save();

% endif

