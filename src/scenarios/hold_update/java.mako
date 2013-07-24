% if mode == 'definition':
Hold.save();

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

Hold hold = new Hold("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/holds/HL6ZyFT7oYPgePv0zFEEH7R0");
hold.description = "update this description";
hold.save();

% endif

