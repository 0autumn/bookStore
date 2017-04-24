package app.store.model.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import app.store.model.entity.Book;
import app.store.model.entity.OrderItem;

public class ShoppingCart {

	protected Map<Long,OrderItem> items;
	
	public ShoppingCart() {
		if (items == null) {
			items = new HashMap<Long, OrderItem>();
		}
	}
	
	/**
	 * ���ͼ�鵽���ﳵ
	 * @param book Ҫ��ӵ����ﳵ��ͼ��
	 * @param quantity �������������0��
	 */
	public void addBook(Book book, int quantity) {
		if (quantity <= 0) return;
		//����ﳵ���Ѿ����ڸ�ͼ�飬�����Ӹ�ͼ�鶩���������
		if (items.containsKey(book.getId())){
			OrderItem item = items.get(book.getId());
			item.setQuantity(item.getQuantity() + quantity);
		}
		else {  //��������µĶ�����
			OrderItem newItem = new OrderItem();
			newItem.setBook(book);
			newItem.setQuantity(quantity);
			items.put(book.getId(), newItem);
		}
	}
	
	/**
	 * ���ͼ��id���¹��ﳵ����Ӧ�����������
	 * @param bookId ͼ��Id
	 * @param quantity �µ��������������0)
	 */
	public void updateQuantity(long bookId, int quantity) {
		if (quantity <= 0) return;
		if (items.containsKey(bookId)){
			OrderItem item = items.get(bookId);
			item.setQuantity(quantity);
		}
	}
	
	/**
	 * �ӹ��ﳵ��ɾ��ָ��id��ͼ��
	 * @param bookId Ҫɾ���ͼ��Id
	 */
	public void removeBook(long bookId) {
		items.remove(bookId);
	}
	
	/**
	 * ���ع��ﳵ����ͼ�鶩������ܼ۸�
	 * @return �ܼ۸�
	 */
	public float getTotalPrice(){
		float totalPrice = 0;
		for (OrderItem item : items.values()){
			Book book = item.getBook();
			totalPrice += book.getPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	
	/**
	 * ���ع��ﳵ������ͼ��Ķ�����
	 * @return �����������
	 */
	public Set<OrderItem> getOrderItems()
	{
		return new HashSet<OrderItem>(items.values());
	}
	
	/**
	 * ��չ��ﳵ
	 */
	public void clear() {
		items.clear();
	}
	
}
