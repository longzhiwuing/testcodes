package com.lzwing.testcode.guice.main;

import com.google.inject.AbstractModule;
import com.lzwing.testcode.guice.main.helloworlddemo.HelloWorldModule;
import com.lzwing.testcode.guice.main.printlndemo.PrintLineModule;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new HelloWorldModule());
		install(new PrintLineModule());
	}
}
