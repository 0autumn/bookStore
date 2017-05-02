package app.store.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import app.store.model.entity.SpecInfo;
import app.store.util.HibernateHelper;

public class SpecInfoDaoHibernateImpl extends EntityDaoHibernateSupport<SpecInfo>{
   public SpecInfoDaoHibernateImpl(){
	   super();
   }
   
   @Override
	public List<SpecInfo> findBy(String propertyName, Object propertyValue) {
	   
	   String queryString = "from " + " SpecInfo " + " e ";
		queryString += "where e." + propertyName + "=:propertyValue";
		 System.out.println(queryString);
	   Session session=	 HibernateHelper.getSession();
		Query query = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<SpecInfo> entities = query.setParameter("propertyValue", propertyValue).list();
		session.close();
		return entities;
	}
}
