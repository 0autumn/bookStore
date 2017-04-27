package app.store.model.service;

import java.util.ArrayList;
import java.util.List;

import app.store.model.entity.Product;

public class ProductServiceImpl extends ServiceSupport<Product> implements
		ProductService {

	@Override
	public Product getBook(long id) {
		return this.getDao().get(id);
	}

	@Override
	public List<Product> getBooksByCategoryId(long id,Integer page,Integer a_page_num) {
		if(page==null)
			page=1;
		if(a_page_num==null){
			a_page_num=10;
		}
		int start=(page-1)*a_page_num;
		List<Product> list=new ArrayList<>();
		List<Product> list1=new ArrayList<>();
		list1=this.getDao().findBy("category.id", id);
		for (int i = 0; i <list1.size(); i++) {
			if((i-start)<a_page_num&&(i-start)>=0){
				list.add(list1.get(i));
			}
		}
		return  list;
	}

	@Override
	public List<Product> getAllBooks() {
		return this.getDao().findAll();
	}

	@Override
	public List<Product> searchBookFor(String keyword,Integer page,Integer a_page_num) {
		if(page==null)
			page=1;
		int num=0;
		int srart=(page-1)*12;
		List<Product> resultBooks = new ArrayList<Product>();
		List<Product> allBooks = this.getAllBooks();
		for (Product book : allBooks){
			if (book.getName().contains(keyword) || 
				book.getCategory().getName().contains(keyword) || 
				book.getCategory().getDescription().contains(keyword)) {
				   if(num>srart)
				       resultBooks.add(book);
			}
			num++;
			if((num-srart)>a_page_num)
				break;
		}
		return resultBooks;
	}

}
