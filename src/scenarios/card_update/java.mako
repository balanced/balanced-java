% if mode == 'definition':
Card().save()

% else:
Balanced.configure("ak-test-2eKlj1ZDfAcZSARMf3NMhBHywDej0avSY");

Card card = new Card("/cards/CC4zyuNpxY0A0eAf87SeULCR");

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

