% if mode == 'definition':
Card.save();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Card card = new Card("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/cards/CC6m2aWsnilcUxa1hzF3l0Sk");
Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");
card.meta = meta;
card.save();


% endif

