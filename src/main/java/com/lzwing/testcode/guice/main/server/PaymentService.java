package com.lzwing.testcode.guice.main.server;

public interface PaymentService {

	void pay(long orderId, long price, Long sessionId);

}
