% if mode == 'definition':
Credit().save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Credit credit = new Credit("/credits/CR4RdgCoOqYhr4sjPdcDjf3T");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.id", "1234567890");
meta.put("anykey", "valuegoeshere");

credit.meta = meta;
credit.description = "New description for credit";

try {
    credit.save();
}
catch (HTTPError e) {}

% endif

