% if mode == 'definition':
Card().save()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Card card = new Card("/cards/CC5zxUdioIB0Dc2rjM1PK3Cw");

Map<String, String> meta = new HashMap<String, String>();
meta.put("facebook.user_id", "0192837465");
meta.put("my-own-customer-id", "12345");
meta.put("twitter.id", "1234987650");

card.meta = meta;

try {
    card.save();
}
catch (HTTPError e) {}

% endif

