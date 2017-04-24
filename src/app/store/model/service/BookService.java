package app.store.model.service;

import java.util.List;

import app.store.model.entity.Book;

public interface BookService {

	/**
	 * ����ָ��id��ͼ��
	 * @param id ͼ��Id
	 * @return ָ����ͼ�����
	 */
	public Book getBook(long id);
	
	/**
	 * ����ָ��ͼ�����id�µ�����ͼ��
	 * @param id ����Id
	 * @return ָ�������µ�����ͼ����б�
	 */
	public List<Book> getBooksByCategoryId(long id);
	
	/**
	 * ��������ͼ��
	 * @return ����ͼ����б�
	 */
	public List<Book> getAllBooks();
	
	/**
	 * ������ָ���ؼ��ֵ�ͼ��
	 * @param keyword �ؼ���
	 * @return ��ؼ��ֵ�ͼ���б�
	 */
	public List<Book> searchBookFor(String keyword);
	
}
