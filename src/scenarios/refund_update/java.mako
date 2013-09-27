% if mode == 'definition':
Refund.save();

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Refund refund = new Refund("/v1/customers/CU5uG18syxNwvFGdbknjZmoo/refunds/RF5DdvCEcpQXCNd6F96mfxC6");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";
refund.save();


% endif

