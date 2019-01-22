package rco.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rco.springmvc.dao.UserDAOImpl;
import rco.springmvc.model.Login;
import rco.springmvc.model.User;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	public UserServiceImpl()
	{
		this.userDAOImpl = new UserDAOImpl();
	}
	
	public User validateUser(Login login)
	{
		return userDAOImpl.validateUser(login);
	}

	public boolean checkUserAuthentification(Login login)
	{
		return userDAOImpl.checkUserAuthentification(login);
	}
	
	public void signup(User user)
	{
		userDAOImpl.signup(user);
	}
	
	public void createUser(String username, String password, String firstname, String lastname, String email,
			String address, String phone) 
	{
		this.userDAOImpl.createUser(username, password, firstname, lastname, email, address, phone);
	}
	
	public UserDAOImpl getUserServiceImpl()
	{
		return userDAOImpl;
	}
	
}
