% if mode == 'definition':

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/bank_accounts");
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

