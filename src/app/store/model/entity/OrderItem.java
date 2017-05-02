package app.store.model.entity;

import java.util.Set;

public class OrderItem extends Entity {
	
	private int quantity;
	private Order order;
	private Product product;
	private Set<ProductValue> productValues;

	public OrderItem() {
		super(0);
		this.setQuantity(0);
	}

	public Set<ProductValue> getProductValues() {
		return productValues;
	}

	public void setProductValues(Set<ProductValue> productValues) {
		this.productValues = productValues;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		//order.addOrderItem(this);
	}

	public Product getBook() {
		return product;
	}

	public void setBook(Product book) {
		this.product = book;
	}

}
