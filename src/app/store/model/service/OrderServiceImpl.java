package app.store.model.service;

import app.store.model.entity.Order;

public class OrderServiceImpl extends ServiceSupport<Order> implements
		OrderService {

	@Override
	public void saveOrder(Order order) {
		this.getDao().save(order);

	}

}
