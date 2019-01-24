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
	
	@Override
	public User validateUser(Login login)
	{
		return userDAOImpl.validateUser(login);
	}

	@Override
	public User getUserInfo(String username, String password)
	{
		return userDAOImpl.getUserInfo(username, password);
	}
	
	@Override
	public void signup(User user)
	{
		userDAOImpl.signup(user);
	}
	
	@Override
	public void signup(User user, String profil)
	{
		userDAOImpl.signup(user, profil);
	}
		
	public UserDAOImpl getUserServiceImpl()
	{
		return userDAOImpl;
	}

	@Override
	public User getUserInfo(String username) 
	{
		return userDAOImpl.getUserInfo(username);
	}
	
}
