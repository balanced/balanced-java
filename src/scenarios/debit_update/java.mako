% if mode == 'definition':
Card card = new Card();

% else:
    Debit debit = new Debit("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/debits/WD706iriHZn5MZEyQ86DmHmE");
    debit.description = "New description for debit";
    Map<String, String> meta = new HashMap<String, String>();
    meta.put("anykey", "valuegoeshere");
    meta.put("facebook.id", "1234567890");
    debit.meta = meta;
    debit.save();

% endif

