% if mode == 'definition':
Credit().save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Credit credit = new Credit("/credits/CR4wyLukORa0TXhCYtjZrfw5");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.id", "1234567890");
meta.put("anykey", "valuegoeshere");

credit.meta = meta;
credit.description = "New description for credit";

credit.save();


% endif

