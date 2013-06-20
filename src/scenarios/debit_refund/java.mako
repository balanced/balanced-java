% if mode == 'definition':
Debit.refund();

% else:
String apiKey = "";
String location = System.getProperty("balanced_location", Settings.location);
String key = System.getProperty("balanced_key", apiKey);
Settings.configure(location, key);

Debit debit = new Debit("/v1/marketplaces/TEST-MP1cY43VkrOlypoTc5lxfstI/debits/WD28XgrtWueKlEm9x1krojCG");
debit.refund();

% endif

