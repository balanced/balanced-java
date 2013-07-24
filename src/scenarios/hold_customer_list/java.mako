% if mode == 'definition':
Customer.holds;

% else:
Settings.configure("6f755804f3e111e295f6026ba7cd33d0");

Customer customer = new Customer("");
Hold.Collection holds = customer.holds;

% endif

