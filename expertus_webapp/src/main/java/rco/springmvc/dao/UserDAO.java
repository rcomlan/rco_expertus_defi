package rco.springmvc.dao;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserDAO {
	
	void signup(User user);
	
	void signup(User user, String profil);
	
	User getUserInfo(String username, String password);
	
	User getUserInfo(String username);
		
	User validateUser(Login login);

}
