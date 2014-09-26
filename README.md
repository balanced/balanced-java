# Balanced

Online Marketplace Payments

[![Build Status](https://secure.travis-ci.org/balanced/balanced-java.png)](http://travis-ci.org/balanced/balanced-java)

**v1.x requires Balanced API 1.1. Use [v0.x](https://github.com/balanced/balanced-java/tree/rev0) for Balanced API 1.0.**

## Requirements

- [gson](http://code.google.com/p/google-gson/) 2.2.2
- [httpclient](http://hc.apache.org/) 4.2.1
- [commons-lang](http://commons.apache.org/lang/) 3.1
- [commons-codec](http://commons.apache.org/codec/) 1.7

Which you can download to `target/dependency` using:

    $ mvn dependency:copy-dependencies

## Issues

Please [Github issues](https://github.com/balanced/balanced-java/issues) to request features or report bugs.

## Installation

### Maven

Add this dependency to your `pom.xml`:

    <dependency>
	    <groupId>com.balancedpayments</groupId>
	    <artifactId>balancedpayments</artifactId>
	    <version>1.0</version>
    </dependency>

**NOTE**: the `<version>XXX</version>` can be out of date in this README.

## Quickstart

See https://docs.balancedpayments.com/1.1/guides/quickstart/?language=java

## Usage

See https://docs.balancedpayments.com/1.1/api/?language=java for guides and documentation.

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
