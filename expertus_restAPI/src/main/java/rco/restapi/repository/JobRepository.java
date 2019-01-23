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
			String _query = "select * from job where job.status = 'available'";	
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
			String _query = "select * from job where job.status = 'closed'";	
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
	
	public JobRepository(Connection connection)throws InstantiationException, IllegalAccessException {
		super(connection, Job.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
