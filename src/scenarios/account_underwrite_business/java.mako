% if mode == 'definition':
    Account.promoteToMerchant(...)

% else:
    Account account = new Account("/v1/marketplaces/TEST-MP64bmAzypIUS0SUZ4qkoFqG/accounts");
    HashMap merchantPayload = new HashMap<String, Object>();
    
    merchantPayload["{name=Skripts4Kids, person={dob=1989-12, name=Timmy Q. CopyPasta, phone_number=+14089999999, postal_code=94110, street_address=121 Skriptkid Row}, phone_number=+140899188155, postal_code=91111, street_address=555 VoidMain Road, tax_id=211111111, type=business}"];
    
    account.promoteToMerchant(merchantPayload);

% endif

