package app.store.model.service;

import app.store.model.entity.User;

public interface UserService  {

	
	public void saveUser(User user);
	
	
	public User verifyUser(String loginId, String password);
	
}
