% if mode == 'definition':
Debit.save()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Debit debit = new Debit("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/debits/WD4DeFW0rK2mLOe21VPStCWG");
debit.description = "New description for debit";

Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");

debit.meta = meta;
debit.save();

% endif

