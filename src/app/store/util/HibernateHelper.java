package app.store.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateHelper {

	private static SessionFactory sf;
	private static ThreadLocal<Session> hSession=new ThreadLocal<>();
	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			try {
				Configuration conf=new Configuration();
				conf.configure();
				ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();    
		        sf =conf.buildSessionFactory(sr);  
			}
			catch (Throwable ex) {
				System.err.println("sessionFactory:" + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sf;
	}
	
	public static Session getSession(){
		if(hSession.get()==null){
			Session session=getSessionFactory().openSession();
			hSession.set(session);
		}
		return hSession.get();
		
		
	}
}
