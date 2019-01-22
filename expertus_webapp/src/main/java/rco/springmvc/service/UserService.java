package rco.springmvc.service;

import org.springframework.stereotype.Repository;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;

@Repository
public interface UserService 
{
	User validateUser(Login login);
	
	User getUserInfo(String username, String password);
	
	void signup(User user);
	
	void signup(User user, String profil);
	
	void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone);
	
}
