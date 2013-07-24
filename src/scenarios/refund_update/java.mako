% if mode == 'definition':
Refund.save();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Refund refund = new Refund("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/refunds/RF7hsO01rx8siK1kV6nVWP39");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";
refund.save();


% endif

