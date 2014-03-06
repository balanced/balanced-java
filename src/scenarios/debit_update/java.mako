% if mode == 'definition':
Debit.save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Debit debit = new Debit("/debits/WD4scrlw85LkeIEQqOx3AgUW");
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

