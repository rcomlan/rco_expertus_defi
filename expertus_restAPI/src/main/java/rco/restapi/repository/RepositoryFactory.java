package rco.restapi.repository;

import java.sql.Connection;
import rco.restapi.model.MySQLConnection;

public class RepositoryFactory 
{
	private JobRepository _job;
	private JobApplicationRepository _jobApplication;
	private static Connection _dbConnection;
	
	public JobRepository Job()
	{
		if(this._job == null)
		{
			try {
				_job = new JobRepository(_dbConnection);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _job;
		}
		else
		{
			return _job;
		}
	}
	
	public JobApplicationRepository JobApplication()
	{
		if(this._jobApplication == null)
		{
			try {
				_jobApplication = new JobApplicationRepository(_dbConnection);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _jobApplication;
		}
		else
		{
			return _jobApplication;
		}
	}
	
	
	
	public RepositoryFactory(MySQLConnection db)
	{	
		_dbConnection = MySQLConnection.getInstance();  
	}

}
