% if mode == 'definition':

% else:
Settings.configure("2776ea40d92e11e29fe1026ba7cac9da");

BankAccount ba = new BankAccount("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/bank_accounts");
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

