# KwikDesk Partner API Java Client Library

The KwikDesk Partner API Java client provides a simple interface to the [KwikDesk Partner API](https://partners.kwikdesk.com).

## Requirements

Java 6 or later.

## Install

	mvn install

## Usage

	String token = KwikDesk.api.token("my-app").getToken();
	KwikDesk.api.message(token, new Message("This is a private message on a secure channel"));
	ChannelResponse response = KwikDesk.api.channel(token);
	SearchResponse response = KwikDesk.api.search(token, "kwikdesk");
	KwikDesk.api.time();

