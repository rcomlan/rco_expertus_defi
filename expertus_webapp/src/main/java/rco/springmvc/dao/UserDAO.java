package rco.springmvc.dao;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserDAO {
	
	void signup(User user);
	
	void signup(User user, String profil);
	
	void createAdmin(String username, String password, String firstname, String lastname, String email, String address, String phone, String profil);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone, byte[] resume);
	
	User getUserInfo(String username, String password);
	
	User getUserInfo(String username);
		
	User validateUser(Login login);

}
