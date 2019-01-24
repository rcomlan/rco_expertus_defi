package rco.springmvc.model;

import java.sql.Blob;

public class JobApplication
{

	private String refjob;
	private String username;
	private String availability_date;
	private Blob resume;
	
	public JobApplication() {
		
	}
	
	
	public JobApplication(String refjob, String username, String availability_date, Blob resume) {
		super();
		this.refjob = refjob;
		this.username = username;
		this.availability_date = availability_date;
		this.resume = resume;
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


	public Blob getResume() {
		return resume;
	}


	public void setResume(Blob resume) {
		this.resume = resume;
	}

	
	
}
