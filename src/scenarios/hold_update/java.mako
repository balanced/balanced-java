% if mode == 'definition':
Hold.save();

% else:
Settings.configure("71d76c1223ad11e38848026ba7c1aba6");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/holds/HL5iaMpKeWTH4nMWYyItmOZy");
hold.description = "update this description";
hold.save();

% endif

