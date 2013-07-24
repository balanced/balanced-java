% if mode == 'definition':

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP3oDYBxCRm2CVSWGt1RRctG/bank_accounts");
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

