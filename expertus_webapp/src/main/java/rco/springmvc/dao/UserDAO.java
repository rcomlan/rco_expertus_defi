package rco.springmvc.dao;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserDAO {
	
	void register(User user);
	
	boolean checkUserAuthentification(String username, String password);
	
	User validateUser(Login login);

}
