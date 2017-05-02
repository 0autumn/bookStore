package app.store.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.store.model.dao.ProductValueDaoHibenateImpl;
import app.store.model.dao.SpecInfoDaoHibernateImpl;
import app.store.model.entity.Product;
import app.store.model.entity.OrderItem;
import app.store.model.entity.ProductValue;
import app.store.model.entity.SpecInfo;

public class ShoppingCart {
    private	SpecInfoDaoHibernateImpl sih;
	protected Map<Long,OrderItem> items;
	


	public SpecInfoDaoHibernateImpl getSih() {
		return sih;
	}


	public void setSih(SpecInfoDaoHibernateImpl sih) {
		this.sih = sih;
	}


	public ShoppingCart() {
		if (items == null) {
			items = new HashMap<Long, OrderItem>();
		}
	}
	
	
	public void addBook(Product book, int quantity,long[] valueId ) {
		if (quantity <= 0) return;
	
		if (items.containsKey(book.getId())){
			OrderItem item = items.get(book.getId());
			item.setQuantity(item.getQuantity() + quantity);
		}
		else {  
			OrderItem newItem = new OrderItem();
			newItem.setBook(book);
			newItem.setQuantity(quantity);
			newItem.setProductValues(getAttri(valueId,newItem));
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
	
	public List<Long> getPoductIds(){
		List<Long> list=new ArrayList<>();
		for (OrderItem item : items.values()){
			Product book = item.getBook();
			list.add(book.getId());
		}
		return list;
		
		
	}
	public Set<ProductValue> getAttri(long[] valueId,OrderItem orderItem){
		Set<ProductValue> set=new HashSet<ProductValue>();
		SpecInfoDaoHibernateImpl sih=new SpecInfoDaoHibernateImpl();
		for (int i = 0; i < valueId.length; i++) {
			ProductValue pv=new ProductValue();
		    SpecInfo sif=sih.findBy("id",valueId[i]).get(0);
			pv.setSpecinfo(sif);
			pv.setSpec(sif.getSpec());
			System.out.println(sif.getSpec().getSpec_name()+"-1111111111111-");
			pv.setOrderItem(orderItem);
			set.add(pv);
		}
		return set;
		
	}
}
