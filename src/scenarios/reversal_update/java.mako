% if mode == 'definition':
Reversal().save()

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

Reversal reversal = new Reversal("/reversals/RV1N9oslZhbE86nYOnfJHzHO");

Map<String, String> meta = new HashMap<String, String>();
meta.put("reversal.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.satisfaction", "6");

reversal.meta = meta;
reversal.description = "update this description";

try {
    reversal.save();
}
catch (HTTPError e) {}


% endif

