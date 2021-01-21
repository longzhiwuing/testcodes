package com.lzwing.testcode.guice.test.server.impl;

import com.google.inject.Guice;
import com.lzwing.testcode.guice.main.server.impl.ServerModule;
import com.lzwing.testcode.guice.main.server.impl.SessionManager;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertNotEquals;

public class SessionManagerTest {
	@Inject
	SessionManager sessionManager;

	@Before public void setUp() {
		Guice.createInjector(new ServerModule())
				.injectMembers(this);
	}

	@Test
	public void testGetSessionId() throws InterruptedException {
		Long sessionId1 = sessionManager.getSessionId();
		// Pretend we sleep long enough so session expires.
		Thread.sleep(1000);
		Long sessionId2 = sessionManager.getSessionId();
		assertNotEquals(
				sessionId2.longValue(), sessionId1.longValue());
	}

}
