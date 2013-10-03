% if mode == 'definition':
Account.associateCard(String uri)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/accounts");
account.associateCard("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC39mRUIsOwPIbNr5Om29FvN");

% endif

