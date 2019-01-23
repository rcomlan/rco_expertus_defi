package rco.restapi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobApplication extends ExtenderMySQLModel
{

	private String refjob;
	private String username;
	private String availability_date;
	
	public JobApplication() {
		
	}
	
	

	public JobApplication(String refjob, String username) {
		super();
		this.refjob = refjob;
		this.username = username;
	}



	public String getRefjob() {
		return refjob;
	}



	public void setRefjob(String refjob) {
		this.refjob = refjob;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getAvailability_date() {
		return availability_date;
	}



	public void setAvailability_date(String availability_date) {
		this.availability_date = availability_date;
	}



	@Override
	public String GetDatabaseTableName() {
		// TODO Auto-generated method stub
		return "job_application";
	}

	@Override
	public Object MapToModel(ResultSet resultSet) 
	{
		// TODO Auto-generated method stub
		JobApplication jobApplication = new JobApplication();
		
		try {
			jobApplication.setUsername(resultSet.getString("username"));		
			jobApplication.setRefjob(resultSet.getString("refjob"));
			jobApplication.setAvailability_date(resultSet.getString("availability_date"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobApplication;
	}

}
