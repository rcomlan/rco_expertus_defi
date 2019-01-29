package rco.restapi.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rco.restapi.model.Job;
import rco.restapi.model.JobApplication;

public class JobApplicationRepository extends RepositoryBase<JobApplication>
{
	
	public List<Job> GetAppliedJobs()
	{
		Job job = new Job();
		List<Job> ts = new ArrayList();
		try {
			String _query = "select job.refjob, job.url, job.datepublish, job.endpublishdate, job.jobtitle, job.level, job.salary, job.status from job, user, job_application where user.username = job_application.username and job.refjob = job_application.refjob";	
			Statement stmt = super._dbConnection.createStatement();
			ResultSet _resultSet = stmt.executeQuery(_query);	
			 while (_resultSet.next()) {
		            ts.add((Job)job.MapToModel(_resultSet));
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ts;
	}
	
	public List<Job> GetAppliedJobsforAnUser(String username)
	{
		Job job = new Job();
		List<Job> ts = new ArrayList();
		try {
			String _query = "select job.refjob, job.url, job.datepublish, job.endpublishdate, job.jobtitle, job.level, job.salary, job.status from job, user, job_application where user.username = job_application.username and job.refjob = job_application.refjob and user.username = '" + username + "'";	
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
	
	public JobApplicationRepository(Connection connection)throws InstantiationException, IllegalAccessException {
		super(connection, JobApplication.class);
		// TODO Auto-generated constructor stub
	}

}
