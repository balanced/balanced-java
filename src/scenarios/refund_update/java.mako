% if mode == 'definition':
    Refund.save()

% else:
    Refund refund = new Refund("/v1/customers/CU6W5pSk2CUXQxhENqyGRvQe/refunds/RF7rcQFmIUkcoIHnpZcnQk5W");

    Map<String, String> meta = new HashMap<String, String>();
    meta.put("refund.reason", "user not happy with product");
    meta.put("user.notes", "very polite on the phone");
    meta.put("user.refund.count", "3");
    refund.meta = meta;
    refund.description = "update this description";
    refund.save();


% endif

