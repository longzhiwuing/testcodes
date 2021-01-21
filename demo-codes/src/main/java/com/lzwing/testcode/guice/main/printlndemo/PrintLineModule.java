package com.lzwing.testcode.guice.main.printlndemo;

import com.google.inject.AbstractModule;
import com.lzwing.testcode.guice.main.Applets;

public class PrintLineModule extends AbstractModule {

	@Override
	protected void configure() {
		Applets.register(binder()).named("println")
			.to(PrintLineApplet.class);
	}
}
