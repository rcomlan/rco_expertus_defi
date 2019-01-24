package rco.springmvc.dao;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import rco.springmvc.service.MySQLConnection;

public class JobApplicationDAOImpl implements JobApplicationDAO
{
	
	private Connection connection;
    private Statement st;
    private String sql;
    
    @Autowired
	DataSource datasource;
	
	public JobApplicationDAOImpl()
	{
		
	}

	@Override
	public void addJobApplication(String username, String refjob, String availability_date, Blob resume) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "insert into job_application" + "(username, refjob, availability_date, resume) VALUES" + "(?,?,?,?)";
			PreparedStatement p_st = (PreparedStatement) connection.prepareStatement(sql);
			// Binding datas to parameters
			p_st.setString(1, username);
			p_st.setString(2, refjob);
			p_st.setString(3, availability_date);
			p_st.setBlob(4, resume);
			p_st.executeUpdate();
		    p_st.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
