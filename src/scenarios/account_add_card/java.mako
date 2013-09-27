% if mode == 'definition':
Account.associateCard(String uri);

% else:
Balanced.configure("71d76c1223ad11e38848026ba7c1aba6");

Account account = new Account("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/accounts/CU3DVmB4y4VJnHcb6X9qnSnS");
account.associateCard("/v1/marketplaces/TEST-MP3t1UYs4ixXWfZ79kXhEUcy/cards/CC3G4m4IFSShCmYZXyWRTM7g");

% endif

