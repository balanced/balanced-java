% if mode == 'definition':
Account.associateCard(String uri)

% else:
Balanced.configure("ak-test-2ppXve1BnInnsIKZytspDrsuhjtAT9dD8");

Account account = new Account("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/accounts/CU39U7FCqdW1fuo2tIKt0J0H");
account.associateCard("/v1/marketplaces/TEST-MP2YQknCUwTrp3NiNxuqDEpi/cards/CC3cwP0s0M0mcmQUKDFkFIHu");

% endif

