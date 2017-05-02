package app.store.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import app.store.model.entity.Product;
import app.store.model.entity.Order;
import app.store.model.entity.OrderItem;
import app.store.model.entity.ProductValue;
import app.store.model.entity.Spec;
import app.store.model.entity.User;
import app.store.model.service.ProductService;
import app.store.model.service.OrderService;
import app.store.model.service.ProductValueServiceImpl;
import app.store.model.service.ShoppingCart;
import app.store.model.service.SpecServiceImpl;

public class ShoppingAction extends GenericActionSupport<Order, OrderService>{
	
	private static final long serialVersionUID = 1L;
	
	private long[] bookId;
	private int[] quantity;
	private long[] id;
	private ProductService productService;
	private ProductValueServiceImpl productValueService;
	private SpecServiceImpl specSevice;
   /* private List<Object> listOred;*/
   
	




/*	public List<Object> getListOred() {
		return listOred;
	}


	public void setListOred(List<Object> listOred) {
		this.listOred = listOred;
	}
*/




	public ProductService getProductService() {
		return productService;
	}



	public long[] getId() {
		return id;
	}



	public void setId(long[] id) {
		this.id = id;
	}



	public SpecServiceImpl getSpecSevice() {
		return specSevice;
	}

	public void setSpecSevice(SpecServiceImpl specSevice) {
		this.specSevice = specSevice;
	}
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
		

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public ProductValueServiceImpl getProductValueService() {
		return productValueService;
	}

	public void setProductValueService(ProductValueServiceImpl productValueService) {
		this.productValueService = productValueService;
	}
	
		  
	    
	    	
		
	    	
	   
	public String addToCart() throws Exception {
	 
		Product book = productService.getBook(this.getBookId()[0]);
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		if (cart == null) {
			cart = new ShoppingCart();
		}
		cart.addBook(book, this.getQuantity()[0],id);
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
		cart.removeBook(this.getBookId()[0]);
		
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
			this.addActionMessage("k");
			return INPUT;
		}
		if (cart == null) {
			this.addActionError("璐墿杞︿负绌�");
			return ERROR;
		}
		/*  List<Object> list0=new ArrayList<>();
	    List<Long> list1=new ArrayList<>();
	  
	    List<Object> order=new ArrayList<>();
	      order.addAll(cart.getOrderItems());
		list1=cart.getPoductIds();
	for (int j = 0; j < order.size(); j++) {
	
		 Map<String,Object> ordeJsp=new HashMap<>();
		OrderItem ordeItem=new OrderItem();
		ordeItem=(OrderItem) order.get(j);
		List<Map<String,Object>> list=new ArrayList<>();
    	List<Spec> specs=this.specSevice.getaSpec(list1.get(j));
    	    for (int i = 0; i < specs.size(); i++) {
    		Map<String,Object> map=new HashMap<String, Object>();
    		ProductValue productValue=(ProductValue) this.productValueService.getProductAttribute(specs.get(i).getId()).get(0);
		    map.put("specName",productValue.getSpec().getSpec_name());
		    map.put("specValue", productValue.getSpecinfo().getSpec_value());
		    System.out.println(productValue.getSpec().getSpec_name()+"--"+ productValue.getSpecinfo().getSpec_value());
		    list.add(map);
    	}
    	    ordeJsp.put("value",list);
    	    ordeJsp.put("product",ordeItem);
    	  
    	    list0.add(ordeJsp);
		}
	  
		this.setListOred(list0);*/
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
		cart.clear();
		this.setModel(order);
		
	}

}
