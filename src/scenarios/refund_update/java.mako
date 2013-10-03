% if mode == 'definition':
Refund.save()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Refund refund = new Refund("/v1/customers/CU5eN73VZL9xr3qR4VIgtTZI/refunds/RF5tlXeMsrSsrDfJdLEDrDsP");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";
refund.save();


% endif

