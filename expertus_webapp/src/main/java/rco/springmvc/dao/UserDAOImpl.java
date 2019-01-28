package rco.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import rco.springmvc.model.Login;
import rco.springmvc.model.User;
import rco.springmvc.service.MySQLConnection;


public class UserDAOImpl implements UserDAO 
{
	private Connection connection;
    private ResultSet rs = null;
    private User user;
    private Statement st;
    private String sql;
		
	@Autowired
	DataSource datasource;
	
	public UserDAOImpl()
	{
		
	}
	
	@Override
	public void signup(User user) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into user" + "(username, password, firstname, lastname, email, address, phone, resume) VALUES" + "(?,?,?,?,?,?,?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, user.getUsername());
			p_st.setString(2, user.getPassword());
			p_st.setString(3, user.getFirstname());
			p_st.setString(4, user.getLastname());
			p_st.setString(5, user.getEmail());
			p_st.setString(6, user.getAddress());
			p_st.setString(7, user.getPhone());
			p_st.setBytes(8, user.getResume());
			p_st.executeUpdate();
		    p_st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void signup(User user, String profil) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into user" + "(username, password, firstname, lastname, email, address, phone, profil) VALUES" + "(?,?,?,?,?,?,?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, user.getUsername());
			p_st.setString(2, user.getPassword());
			p_st.setString(3, user.getFirstname());
			p_st.setString(4, user.getLastname());
			p_st.setString(5, user.getEmail());
			p_st.setString(6, user.getAddress());
			p_st.setString(7, user.getPhone());
			p_st.setString(8, profil);
			p_st.executeUpdate();
		    p_st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User validateUser(Login login) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			st = (Statement) connection.createStatement();
			sql = "select * from user where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";
		    rs = st.executeQuery(sql);
		    if (rs.next())
		    {
		    	user = new UserMapper().mapRow(rs);
		    }
		    st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return user;
	}
	
	
	@Override
	public void createUser(String username, String password, String firstname, String lastname, String email, String address, String phone, byte[] resume)
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into user" + "(username, password, firstname, lastname, email, address, phone, resume) VALUES" + "(?,?,?,?,?,?,?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, username);
			p_st.setString(2, password);
			p_st.setString(3, firstname);
			p_st.setString(4, lastname);
			p_st.setString(5, email);
			p_st.setString(6, address);
			p_st.setString(7, phone);
			p_st.setBytes(8, resume);
			int row = p_st.executeUpdate();
            if (row > 0) System.out.println("File uploaded and saved into database");
		    p_st.close();
		} 
		catch (SQLException e) 
		{     
	        String message = "ERROR: " + e.getMessage();
	        System.out.println(message);
		}
	}
	
	@Override
	public void createAdmin(String username, String password, String firstname, String lastname, String email, String address, String phone, String profil)
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into user" + "(username, password, firstname, lastname, email, address, phone, profil) VALUES" + "(?,?,?,?,?,?,?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, username);
			p_st.setString(2, password);
			p_st.setString(3, firstname);
			p_st.setString(4, lastname);
			p_st.setString(5, email);
			p_st.setString(6, address);
			p_st.setString(7, phone);
			p_st.setString(8, profil);
			int row = p_st.executeUpdate();
            if (row > 0) System.out.println("Administrator registered successfully");
		    p_st.close();
		} 
		catch (SQLException e) 
		{     
	        String message = "ERROR: " + e.getMessage();
	        System.out.println(message);
		}
	}
	
	
	@Override
	public User getUserInfo(String username, String password) 
	{
		connection = MySQLConnection.getInstance();
		try 
		{
			st = (Statement) connection.createStatement();
			sql = "select * from user where username='" + username + "' and password='" + password + "'";
			rs = st.executeQuery(sql);
		    if (rs.next())
		    {
		    	user = new UserMapper().mapRow(rs);
		    }
		    st.close();	   
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return user;
	}
	
	@Override
	public User getUserInfo(String username) 
	{
		connection = MySQLConnection.getInstance();
		try 
		{
			st = (Statement) connection.createStatement();
			sql = "select * from user where username='" + username + "'";
			rs = st.executeQuery(sql);
		    if (rs.next())
		    {
		    	user = new UserMapper().mapRow(rs);
		    }
		    st.close();	   
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return user;
	}

}

class UserMapper
{
	
	public UserMapper()	{}
	
	public User mapRow(ResultSet rs) throws SQLException 
	{
		User user = new User();
		
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getString("phone"));
		user.setProfil(rs.getString("profil"));
		if (!user.getUsername().equals("admin")) user.setResume(rs.getBytes("resume"));
		
		return user;
	}
}
