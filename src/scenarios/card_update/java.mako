% if mode == 'definition':
Card card = new Card();

% else:
    Card card = new Card("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/cards/CC2thwNijAS2qdwoWtqanNh6");
    Map<String, String> meta = new HashMap<String, String>();
    meta.put("facebook.user_id", "");

% endif

