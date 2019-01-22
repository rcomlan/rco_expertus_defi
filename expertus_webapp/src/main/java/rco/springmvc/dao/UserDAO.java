package rco.springmvc.dao;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserDAO {
	
	void signup(User user);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone);
	
	boolean checkUserAuthentification(Login login);
		
	User validateUser(Login login);

}
