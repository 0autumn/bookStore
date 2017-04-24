package app.store.model.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import app.store.model.entity.Product;
import app.store.model.entity.OrderItem;

public class ShoppingCart {

	protected Map<Long,OrderItem> items;
	
	public ShoppingCart() {
		if (items == null) {
			items = new HashMap<Long, OrderItem>();
		}
	}
	
	
	public void addBook(Product book, int quantity) {
		if (quantity <= 0) return;
	
		if (items.containsKey(book.getId())){
			OrderItem item = items.get(book.getId());
			item.setQuantity(item.getQuantity() + quantity);
		}
		else {  
			OrderItem newItem = new OrderItem();
			newItem.setBook(book);
			newItem.setQuantity(quantity);
			items.put(book.getId(), newItem);
		}
	}
	
	
	public void updateQuantity(long bookId, int quantity) {
		if (quantity <= 0) return;
		if (items.containsKey(bookId)){
			OrderItem item = items.get(bookId);
			item.setQuantity(quantity);
		}
	}
	
	
	public void removeBook(long bookId) {
		items.remove(bookId);
	}
	

	public float getTotalPrice(){
		float totalPrice = 0;
		for (OrderItem item : items.values()){
			Product book = item.getBook();
			totalPrice += book.getPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	

	public Set<OrderItem> getOrderItems()
	{
		return new HashSet<OrderItem>(items.values());
	}
	
	
	public void clear() {
		items.clear();
	}
	
}
