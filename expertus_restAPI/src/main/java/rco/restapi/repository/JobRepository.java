package rco.restapi.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rco.restapi.model.Job;

public class JobRepository extends RepositoryBase<Job>
{
	
	public List<Job> GetAvailableJobs()
	{
		Job job = new Job();
		List<Job> ts = new ArrayList();
		try {
			String _query = "select * from job where job.status = 'Opened'";	
			Statement stmt = super._dbConnection.createStatement();
			ResultSet _resultSet = stmt.executeQuery(_query);	
			 while (_resultSet.next()) {
		            ts.add((Job)job.MapToModel(_resultSet));
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// TODO Auto-generated method stub
		return ts;
		
	}
	
	public List<Job> GetClosedJobs()
	{
		Job job = new Job();
		List<Job> ts = new ArrayList();
		try {
			String _query = "select * from job where job.status = 'Closed'";	
			Statement stmt = super._dbConnection.createStatement();
			ResultSet _resultSet = stmt.executeQuery(_query);	
			 while (_resultSet.next()) {
		            ts.add((Job)job.MapToModel(_resultSet));
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// TODO Auto-generated method stub
		return ts;
		
	}
	
	
	public void addJob(String refjob, String url, String datepublish, String endpublishdate, String jobtitle, String level, Double salary)
	{
		Job job = new Job();
		try {
			String status = "Opened";
			String _query = "insert into job(refjob, url, datepublish, endpublishdate, jobtitle, level, salary, status) values ('" + refjob + "','" + url + "','" + datepublish + "','" + endpublishdate + "', '" + jobtitle + "', '" + level + "', " + salary + ", '" + status + "')";	
			Statement stmt = super._dbConnection.createStatement();
			int _resultSet = stmt.executeUpdate(_query);				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// TODO Auto-generated method stub		
	}
	
	public JobRepository(Connection connection)throws InstantiationException, IllegalAccessException {
		super(connection, Job.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
