% if mode == 'definition':
Hold.save();

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Hold hold = new Hold("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/holds/HL4zmyoTA5gbU1hSVVtLmfiM");
hold.description = "update this description";
hold.save();

% endif

