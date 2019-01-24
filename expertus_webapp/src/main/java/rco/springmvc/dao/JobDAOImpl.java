package rco.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import rco.springmvc.model.Job;
import rco.springmvc.service.MySQLConnection;

public class JobDAOImpl implements JobDAO
{

	private Connection connection;
    private ResultSet rs = null;
    private ArrayList<Job> jobs;
    private Job unJob;
    private Statement st;
    private String sql;
    
    @Autowired
	DataSource datasource;
	
	public JobDAOImpl()
	{
		
	}
	
	@Override
	public ArrayList<Job> getJobsList(String status) 
	{
		try 
		{
			jobs = new ArrayList<Job>();
			connection = MySQLConnection.getInstance();
			sql = "select * from job where status = '" + status + "'";
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next())
			{
				Job unJob = new JobMapper().mapRow(rs);
				jobs.add(unJob);
			}
			st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobs;
	}

	@Override
	public Job getJob(String refjob) 
	{
		try 
		{
			connection = MySQLConnection.getInstance();
			sql = "select * from job where refjob = '" + refjob + "'";
			st = (Statement) connection.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
			{
				unJob = new JobMapper().mapRow(rs);
			}
			st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unJob;
	}
	    
}

class JobMapper
{
	
	public JobMapper()	{}
	
	public Job mapRow(ResultSet rs) throws SQLException 
	{
		Job job = new Job();
		
		job.setRefjob(rs.getString("refjob"));
		job.setDatepublish(rs.getString("datepublish"));
		job.setEndpublishdate(rs.getString("endpublishdate"));
		job.setJobtitle(rs.getString("jobtitle"));
		job.setLevel(rs.getString("level"));
		job.setSalary(rs.getDouble("salary"));
		job.setStatus(rs.getString("status"));
		
		return job;
	}
}
