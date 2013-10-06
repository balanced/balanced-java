% if mode == 'definition':

% else:
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/bank_accounts");
ba.account_number = "9900000001";
ba.routing_number = "100000007";
ba.name = "Johann Bernoulli";
ba.type = "checking";
try {
    ba.save();
}
catch (HTTPError e) {
    // handle invalid routing numbers
}

% endif

