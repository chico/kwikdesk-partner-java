# KwikDesk Partner API Java Client Library

The KwikDesk Partner API Java client provides a simple interface to the [KwikDesk Partner API](https://partners.kwikdesk.com).

## Requirements

Java 6 or later.

## Install

	mvn install
	mvn test

## Usage

	SearchResponse response = KwikDesk.api.search("#kwikdesk");
	KwikDesk.api.message("secret-token", "This is the message I want to post #kwikdesk");
