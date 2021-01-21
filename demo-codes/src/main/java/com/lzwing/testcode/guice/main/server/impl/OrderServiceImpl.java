package com.lzwing.testcode.guice.main.server.impl;

import com.lzwing.testcode.guice.main.Logged;
import com.lzwing.testcode.guice.main.server.OrderService;
import com.lzwing.testcode.guice.main.server.PaymentService;
import com.lzwing.testcode.guice.main.server.PriceService;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService {

	// Dependencies
	private final PriceService priceService;
	private final PaymentService paymentService;
	private final SessionManager sessionManager;

	// States
	private Long ordersPaid = 0L;

	@Inject
	public OrderServiceImpl(PriceService priceService,
			PaymentService paymentService,
			SessionManager sessionManager) {
		super();
		this.priceService = priceService;
		this.paymentService = paymentService;
		this.sessionManager = sessionManager;
	}

	@Override @Logged
	public void sendToPayment(long orderId) {
		long price = priceService.getPrice(orderId);
		paymentService.pay(orderId, price,
				sessionManager.getSessionId());
		ordersPaid = ordersPaid + 1;

		throw new RuntimeException(
				"Price=" + price
				+ ". SessionId="
						+ sessionManager.getSessionId()
				+ ". OrdersPaid=" + ordersPaid);
	}
}