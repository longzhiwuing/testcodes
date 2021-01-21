package com.lzwing.testcode.guice.main.helloworlddemo;

import com.google.inject.Provider;
import com.lzwing.testcode.guice.main.MyApplet;

import javax.inject.Inject;

public class StringWritingApplet implements MyApplet {

	private MyDestination destination;
	private Provider<String> stringProvider;

	@Inject
	public StringWritingApplet(MyDestination destination,
			@Output Provider<String> stringProvider) {
		super();
		this.destination = destination;
		this.stringProvider = stringProvider;
	}

	private void writeString() {
		destination.write(stringProvider.get());
	}

	public void run() {
		writeString();
	}
}
