package rco.springmvc.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import rco.springmvc.service.MySQLConnection;

public class JobApplicationDAOImpl implements JobApplicationDAO
{
	
	private Connection connection;
    private String sql;
    
    @Autowired
	DataSource datasource;
	
	public JobApplicationDAOImpl()
	{
		
	}

	@Override
	public void addJobApplication(String username, String refjob) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into job_application" + "(username, refjob) VALUES" + "(?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, username);
			p_st.setString(2, refjob);
			p_st.executeUpdate();
		    p_st.close();
			p_st.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}

}
