package rco.springmvc.service;

import rco.springmvc.dao.UserDAOImpl;
import rco.springmvc.model.Login;
import rco.springmvc.model.User;

public class UserServiceImpl implements UserService 
{
	
	private UserDAOImpl userDAOImpl;
	
	public UserServiceImpl(UserDAOImpl f_userDAOImpl)
	{
		this.userDAOImpl = f_userDAOImpl;
	}
	
	public void register(User user)
	{
		
	}
	
	public User validateUser(Login login)
	{
		return this.userDAOImpl.validateUser(login);
	}

	public boolean checkUserAuthentification(String username, String password)
	{
		return this.userDAOImpl.checkUserAuthentification(username, password);
	}

	@Override
	public void createUser(String username, String password, String firstname, String lastname, String email,
			String address, String phone) 
	{
		this.userDAOImpl.createUser(username, password, firstname, lastname, email, address, phone);
	}
}
