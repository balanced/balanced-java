% if mode == 'definition':
Credit().save()

% else:
Balanced.configure("ak-test-2fYjkv4Tz5l3iPCtOlgLolmF15XPXlRCr");

Credit credit = new Credit("/credits/CRzQD72qlmLMGqdvPapoQd0");

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

