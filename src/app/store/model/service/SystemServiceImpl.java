package app.store.model.service;

import app.store.model.dao.EntityDao;
import app.store.model.entity.Book;
import app.store.model.entity.Category;
import app.store.model.entity.Order;
import app.store.model.entity.User;
import app.store.util.DateTimeHelper;

public class SystemServiceImpl extends ServiceSupport<User> implements
		SystemService {
	
	private EntityDao<Book> bookDao;
	private EntityDao<Category> categoryDao;
	private EntityDao<Order> orderDao;
	
	private String feedCode;
	
	public void setFeedCode(String code){
		this.feedCode = code;
	}
	
	public EntityDao<Book> getBookDao() {
		return bookDao;
	}

	public void setBookDao(EntityDao<Book> bookDao) {
		this.bookDao = bookDao;
	}

	public EntityDao<Category> getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(EntityDao<Category> categoryDao) {
		this.categoryDao = categoryDao;
	}

	public EntityDao<Order> getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(EntityDao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void feedSampleData(String feedCode) throws Exception{
		System.out.println(this.feedCode);
		if (feedCode.equals(this.feedCode))
		{
			addUsers();
			addCategoryAndBooks();
		}
		else 
		{
			throw new Exception("日期异常");
		}
	}
	
	private void addUsers()
	{
		//��������û�
		User user1 = new User("sa@bookstore.com","ϵͳ����Ա","123456",'M',DateTimeHelper.getDateTimeFrom("1988-12-12"));
		User user2 = new User("zhangsan@bookstore.com","����","123456",'M',DateTimeHelper.getDateTimeFrom("1982-02-14"));
		User user3 = new User("test@bookstore.com","�����û�","1234",'F',DateTimeHelper.getDateTimeFrom("1991-10-1-"));
		//�����û�
		this.getDao().save(user1);
		this.getDao().save(user2);
		this.getDao().save(user3);
		
	}
	
	private void addCategoryAndBooks()
	{
		//����ͼ�����
		Category c1 = new Category("�����","�����רҵͼ��");		
		Category c2 = new Category("�ٶ�","�����ٶ�������ͼ��");
		Category c3 = new Category("����Ļ�","����������Ļ���ͼ��");
		//����ͼ�����
		this.getCategoryDao().save(c1);
		this.getCategoryDao().save(c2);
		this.getCategoryDao().save(c3);
		
		//����"�����"��ͼ��
		Book book1 = new Book("Java�������", 29.5f, "book.png");
		book1.setCategory(c1);
		Book book2 = new Book("Java���˼��", 60.0f, "book.png");
		book2.setCategory(c1);
		Book book3 = new Book("Java���ģʽ", 45.0f, "book.png");
		book3.setCategory(c1);
		Book book4 = new Book("iOSӦ�ÿ���", 66.0f, "book.png");
		book4.setCategory(c1);
		Book book5 = new Book("Head First PMP", 80.0f, "book.png");
		book5.setCategory(c1);
		
		//�������ٶ�"��ͼ��
		Book book6 = new Book("��ͽ��ͯ����", 29.5f, "book.png");
		book6.setCategory(c2);
		Book book7 = new Book("ʮ��ֻ����ȥ����", 12.0f, "book.png");
		book7.setCategory(c2);
		Book book8 = new Book("Canimals ��ֽ��", 15.0f, "book.png");
		book8.setCategory(c2);
		Book book9 = new Book("��ʫ�����", 30.0f, "book.png");
		book9.setCategory(c2);
		
		//����������Ļ�����ͼ��
		Book book10 = new Book("�����ĵ�", 32.0f, "book.png");
		book10.setCategory(c3);
		Book book11 = new Book("�ҳ���100��", 60.0f, "book.png");
		book11.setCategory(c3);
		Book book12 = new Book("�в���������ҽ", 35.0f, "book.png");
		book12.setCategory(c3);
		
		//����ͼ��
		this.getBookDao().save(book1);
		this.getBookDao().save(book2);
		this.getBookDao().save(book3);
		this.getBookDao().save(book4);
		this.getBookDao().save(book5);
		this.getBookDao().save(book6);
		this.getBookDao().save(book7);
		this.getBookDao().save(book8);
		this.getBookDao().save(book9);
		this.getBookDao().save(book10);
		this.getBookDao().save(book11);
		this.getBookDao().save(book12);
		
	}
	
}
