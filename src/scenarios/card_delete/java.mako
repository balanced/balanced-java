% if mode == 'definition':
Card().unstore()

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

Card card = new Card("/cards/CCOeoFZJMd94AruXU0wuSI9");
try {
    card.unstore();
}
catch (HTTPError e) {}
catch (NotCreated e) {}

% endif

