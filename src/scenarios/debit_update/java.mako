% if mode == 'definition':
Debit.save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Debit debit = new Debit("/debits/WDx4mKqQWmCevBueqfMcxoO");
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

