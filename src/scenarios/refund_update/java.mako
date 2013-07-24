% if mode == 'definition':
Refund.save();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Refund refund = new Refund("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/refunds/RF4QWWvy7D9tOKsa4xpdZvdC");

Map<String, String> meta = new HashMap<String, String>();
meta.put("refund.reason", "user not happy with product");
meta.put("user.notes", "very polite on the phone");
meta.put("user.refund.count", "3");
refund.meta = meta;
refund.description = "update this description";
refund.save();


% endif

