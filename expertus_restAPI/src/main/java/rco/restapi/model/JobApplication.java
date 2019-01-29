package rco.restapi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobApplication extends ExtenderMySQLModel
{

	private String refjob;
	private String username;
	
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobApplication;
	}

}
