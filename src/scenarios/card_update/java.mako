% if mode == 'definition':
Card.save();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Card card = new Card("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/cards/CC3TjiGF641gL1cToSJpB7cz");
Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");
card.meta = meta;
card.save();


% endif

