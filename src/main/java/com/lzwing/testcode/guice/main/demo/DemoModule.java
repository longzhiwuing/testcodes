package com.lzwing.testcode.guice.main.demo;

import com.google.inject.AbstractModule;
import com.lzwing.testcode.guice.main.MyApplet;
import com.lzwing.testcode.guice.main.helloworlddemo.MyDestination;
import com.lzwing.testcode.guice.main.helloworlddemo.Output;
import com.lzwing.testcode.guice.main.helloworlddemo.PrintStreamWriter;
import com.lzwing.testcode.guice.main.helloworlddemo.StringWritingApplet;

import java.io.PrintStream;

public class DemoModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MyApplet.class).to(StringWritingApplet.class);

		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);

		bind(String.class).annotatedWith(Output.class).toInstance("hello,world");
	}
}
