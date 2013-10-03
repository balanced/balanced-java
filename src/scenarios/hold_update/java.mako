% if mode == 'definition':
Hold.save()

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Hold hold = new Hold("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/holds/HL52kZFtZTaaxBfENP6l6y48");
hold.description = "update this description";
hold.save();

% endif

