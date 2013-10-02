% if mode == 'definition':

% else:
Settings.configure("c07a8282f49111e2a035026ba7d31e6f");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP5Rwi1N0GqQZ9nAyf11c2v0/bank_accounts");
ba.account_number = "9900000001";
ba.routing_number = "111111118";
ba.name = "Johann Bernoulli";
ba.type = "checking";
try {
    ba.save();
}
catch (HTTPError e) {
    // handle invalid routing numbers
}

% endif

