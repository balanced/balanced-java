% if mode == 'definition':
    Hold.save()

% else:
        Hold hold = new Hold("/v1/marketplaces/TEST-MP29J5STPtZVvnjAFndM0N62/holds/HL37VojBNnK7JE1PrViGScmQ");
        hold.description = "update this description";
        hold.save();

% endif

