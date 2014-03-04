# Balanced

Online Marketplace Payments

[![Build Status](https://secure.travis-ci.org/balanced/balanced-java.png)](http://travis-ci.org/balanced/balanced-java)

## Requirements

- [gson](http://code.google.com/p/google-gson/) 2.2.2
- [httpclient](http://hc.apache.org/) 4.2.1
- [commons-lang](http://commons.apache.org/lang/) 3.1
- [commons-codec](http://commons.apache.org/codec/) 1.7

Which you can download to `target/dependency` using:

    $ mvn dependency:copy-dependencies

## Issues

Please use appropriately tagged github [issues](https://github.com/balanced/balanced-java/issues) to request features or report bugs.

## Installation

### Maven

Add this dependency to your `pom.xml`:

    <dependency>
	    <groupId>com.balancedpayments</groupId>
	    <artifactId>balancedpayments</artifactId>
	    <version>0.6</version>
    </dependency>

**NOTE**: the `<version>XXX</version>` can be out of date in this README.

## Quickstart

```java
APIKey key = new APIKey();
key.save();
System.out.printf("Our secret is %s\n", key.secret);

System.out.printf("Configure with our secret\n");
Balanced.configure(key.secret);

System.out.printf("Create marketplace\n");
Marketplace mp = new Marketplace();
mp.save();

System.out.printf("Who am I? Easy Merchant.me().uri -> %s\n", Merchant.me().uri);

System.out.printf("Whats my marketplace? Easy Marketplace.mine().uri -> %s\n", Marketplace.mine().uri);

System.out.printf("My marketplace's name is: %s\n", mp.name);
System.out.printf("Changing it to TestFooey..\n");
mp.name = "TestFooey";
mp.save();
System.out.printf("My marketplace's name is now: %s\n", mp.name);

System.out.printf("Cool, let's create (aka tokenize) a card!\n");
Card card = mp.tokenizeCard("5105105105105100", 12, 2015);
System.out.printf("Our card is %s.\n", card.uri);

System.out.printf("Now create our **buyer** account associated with that card\n");
Account buyer = mp.createBuyerAccount("buyer", "buyer@example.org", card.uri, null);
System.out.printf("Our **buyer** account is %s.\n", buyer.uri);

System.out.printf("Lets cardHold some moneyfrom the buyer, say $15\n");
Hold cardHold = buyer.cardHold(1500);

System.out.printf("And now capture that money\n");
Debit debit = cardHold.capture();
System.out.printf("Which gives us this debit %s\n", debit.uri);

mp.refresh();
System.out.printf("Sweet, now we have this much in escrow %s\n", mp.in_escrow);

System.out.printf("But lets refund the full amount\n");
Refund refund = debit.refund();

mp.refresh();
System.out.printf("So now we have this much in escrow %s\n", mp.in_escrow);

System.out.printf("That was the buyer, now lets add a **merchant** account\n");

Map<String, Object> identity = new HashMap<String, Object>();
identity.put("type", "person");
identity.put("name", "Billy Jones");
identity.put("street_address", "801 High St");
identity.put("postal_code", "94301");
identity.put("country_code", "USA");
identity.put("dob", "1979-02");
identity.put("phone_number", "+16505551234");

BankAccount bank_account = mp.tokenizeBankAccount(
        "Jack Q Merchant",
        "123123123",
        "123123123",
        BankAccount.Checking);

Account merchant = mp.createMerchantAccount(
        "Jack Q Merchant",
        "merchant@example.org",
        bank_account.uri,
        identity,
        null);
System.out.printf("Our **merchant** account is %s.\n", merchant.uri);

System.out.printf("Our **buyer** wants to purchase something from our **merchant** for $130.\n");
debit = buyer.debit(13000, "TestFooey.COM");

System.out.printf("Lets credit the **merchant** $110 of that $130.\n");
Credit credit = merchant.credit(11000, "Purchase on TestFooey");

System.out.printf("We are the marketplace and charge 15%%, so we just earned $20!\n");
mp.owner_account.credit(2000, "Commission for TestFooey");

System.out.printf("Now the **buyer** wants to deactivate their card.\n");
card.is_valid = false;
card.save();

System.out.printf("Hey I stored the URI, how can I get the object?\n");
Account.get(buyer.uri);
Credit.get(credit.uri);
Debit.get(debit.uri);

System.out.printf("And there you have it :)\n");
```

## Usage

See https://www.balancedpayments.com/docs/api#java for tutorials and documentation.

## Testing

    $ mvn test

## Publishing

[Sonatype OSS repository](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide).

### Snapshot

    $ mvn clean deploy

### Stage Release

    $ mvn release:clean
    $ mvn release:prepare
    $ mvn release:perform

### Release

Done using the [Sonatype Nexus UI](https://oss.sonatype.org/).

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Write your code **and tests**
4. Ensure all [tests](#testing) still pass
5. Commit your changes (`git commit -am 'Add some feature'`)
6. Push to the branch (`git push origin my-new-feature`)
7. Create new pull request

## Contributors

* [You](https://github.com/balanced/balanced-java/issues)!
