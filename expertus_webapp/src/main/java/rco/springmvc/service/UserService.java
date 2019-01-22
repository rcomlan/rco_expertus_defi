package rco.springmvc.service;

import org.springframework.stereotype.Repository;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

@Repository
public interface UserService 
{
	User validateUser(Login login);
	
	boolean checkUserAuthentification(Login login);
	
	void signup(User user);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone);
	
}
