package app.store.model.dao;

import java.util.List;
import org.hibernate.Session;

import app.store.model.entity.ProductValue;

import org.hibernate.Query;


import app.store.model.entity.ProductValue;

public class ProductValueDaoHibenateImpl extends EntityDaoHibernateSupport<ProductValue> {
		  public ProductValueDaoHibenateImpl(){
			  super();
		  }
		  
	public ProductValue find(String propertyName, long propertyValue,long categoryId) {
				String queryString = "from " +" ProductValue "+ " e ";
				queryString += "where e." + propertyName + "=:propertyValue"+"and categoryId"+"=:categoryId";
				Query query = this.getSession().createQuery(queryString);
				 query.setParameter("propertyValue", propertyValue);
				 query.setParameter("categoryId", categoryId);
			  ProductValue	 productValue =(ProductValue) query.list().get(0);
			return productValue;
			}
       public void hh(){
    	   
       }




	public ProductValue find(String propertyName,long categoryId) {
		System.out.println(categoryId+"++++++++++");
		String queryString = "from " + " ProductValue " + " e ";
		queryString += "where e." +propertyName + "=:categoryId";
				 Session session= this.getSession();
						 Query query =session.createQuery(queryString);
				query.setParameter("categoryId", categoryId);
			    ProductValue	productValue =(ProductValue) query.list().get(0);
			return productValue;
			}
      

}
