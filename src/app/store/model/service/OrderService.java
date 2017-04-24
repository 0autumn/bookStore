package app.store.model.service;

import app.store.model.entity.Order;

public interface OrderService {

	/**
	 * ���涩��
	 * @param order Ҫ����Ķ�������
	 */
	public void saveOrder(Order order);
}
