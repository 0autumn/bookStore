package app.store.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import app.store.model.entity.Book;
import app.store.model.entity.Order;
import app.store.model.entity.OrderItem;
import app.store.model.entity.User;
import app.store.model.service.BookService;
import app.store.model.service.OrderService;
import app.store.model.service.ShoppingCart;

public class ShoppingAction extends GenericActionSupport<Order, OrderService>{
	
	private static final long serialVersionUID = 1L;
	
	private long[] bookId;
	private int[] quantity;
	
	private BookService bookService;
	
	public long[] getBookId() {
		return bookId;
	}

	public void setBookId(long[] bookId) {
		this.bookId = bookId;
	}

	public int[] getQuantity() {
		return quantity;
	}

	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
		
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	public String addToCart() throws Exception {
		Book book = bookService.getBook(this.getBookId()[0]);
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		if (cart == null) {
			cart = new ShoppingCart();
		}
		cart.addBook(book, this.getQuantity()[0]);
		session.put("cart", cart);
		return SUCCESS;
	}
	

	public String updateCart() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		
		for(int i = 0; i < getBookId().length; i++)
		{
			cart.updateQuantity(getBookId()[i], getQuantity()[i]);
		}
		
		return SUCCESS;
	}
	

	public String removeFromCart() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		cart.removeBook(getBookId()[0]);
		
		if (cart.getOrderItems().size() == 0) {
			session.remove("cart");
		}
		
		return SUCCESS;
	}
	
	
	public String checkout() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		
		if (user == null) {
			this.addActionMessage("Ҫ���㣬���ȵ�¼!");
			return INPUT;
		}
		if (cart == null) {
			this.addActionError("���ﳵΪ�գ��޷����㣡");
			return ERROR;
		}
		
		doCheckout(user, cart);
		session.remove("cart");
		return SUCCESS;
	}

	private void doCheckout(User user, ShoppingCart cart) {
		Order order = new Order();
		
		order.setUser(user);
		user.addOrder(order);
		
		for(OrderItem item: cart.getOrderItems()){
			item.setOrder(order);
			order.addOrderItem(item);
		}
		order.setTotalPrice(cart.getTotalPrice());
		this.getService().saveOrder(order);
		this.setModel(order);
		cart.clear();
	}
	
}