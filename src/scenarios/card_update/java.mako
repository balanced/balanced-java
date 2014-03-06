% if mode == 'definition':
Card().save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Card card = new Card("/cards/CC4cbNzUmFqGrc1GmFpXp6fe");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

card.meta = meta;

card.save();


% endif

