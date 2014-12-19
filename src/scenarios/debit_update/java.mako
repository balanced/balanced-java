% if mode == 'definition':
Debit.save()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Debit debit = new Debit("/debits/WD6wpBAzwRyTIEdqkKgUSLHa");
debit.description = "New description for debit";

Map<String, String> meta = new HashMap<String, String>();
meta.put("anykey", "valuegoeshere");
meta.put("facebook.id", "1234567890");

debit.meta = meta;

try {
    debit.save();
}
catch (HTTPError e) {}

% endif

