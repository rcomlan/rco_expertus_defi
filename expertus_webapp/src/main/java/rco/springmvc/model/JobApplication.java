package rco.springmvc.model;

public class JobApplication
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

	
}
