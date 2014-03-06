% if mode == 'definition':
Reversal().save()

% else:
Balanced.configure("ak-test-2cSDy37BKy5K4NUHKHVNXNTjTHPEqjRtB");

Reversal reversal = new Reversal("/reversals/RV5h1LgxTlH1OtHAZEfQbvbH");

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

