package rco.springmvc.service;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public interface UserService 
{
	void register(User user);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone);
	
	User validateUser(Login login);
	
	boolean checkUserAuthentification(String username, String password);
	
}
