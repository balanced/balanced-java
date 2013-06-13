% if mode == 'definition':
Card card = new Card();

% else:
    Card card = new Card("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/cards/CC6mSyhNe9lAcrUYtqAxHi1i");
    Map<String, String> meta = new HashMap<String, String>();
    meta.put("facebook.user_id", "");

% endif

