package rco.springmvc.dao;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserDAO {
	
	void signup(User user);
	
	void signup(User user, String profil);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone);
	
	User getUserInfo(String username, String password);
		
	User validateUser(Login login);

}
