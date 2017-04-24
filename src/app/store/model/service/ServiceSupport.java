package app.store.model.service;

import app.store.model.dao.EntityDao;

public class ServiceSupport<TEntity> {

	private EntityDao<TEntity> dao;

	protected EntityDao<TEntity> getDao() {
		return dao;
	}

	public void setDao(EntityDao<TEntity> dao) {
		this.dao = dao;
	}
	
}
