% if mode == 'definition':
Refund().save()

% else:
Balanced.configure("ak-test-1xLFE6RLC1W3P4ePiQDI4UVpRwtKcdfqL");

Refund refund = new Refund("/refunds/RF4zwAHHq8ifpN3M1RLEwSJD");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";

try {
    refund.save();
}
catch (HTTPError e) {}


% endif

