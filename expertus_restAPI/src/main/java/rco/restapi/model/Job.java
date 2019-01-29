package rco.restapi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Job extends ExtenderMySQLModel
{
	
	public String refjob;
	private String url;
	public String datepublish;
	public String endpublishdate;
	public String jobtitle;
	public String level;
	public Double salary;
	public String status;
	
		

	public Job() {

	}

	public Job(String refjob, String url, String datepublish, String endpublishdate, String jobtitle, String level, Double salary,
			String status) {
		super();
		this.refjob = refjob;
		this.url = url;
		this.datepublish = datepublish;
		this.endpublishdate = endpublishdate;
		this.jobtitle = jobtitle;
		this.level = level;
		this.salary = salary;
		this.status = status;
	}

	public String getRefjob() {
		return refjob;
	}

	public void setRefjob(String refjob) {
		this.refjob = refjob;
	}

	public String getDatepublish() {
		return datepublish;
	}

	public void setDatepublish(String datepublish) {
		this.datepublish = datepublish;
	}

	public String getEndpublishdate() {
		return endpublishdate;
	}

	public void setEndpublishdate(String endpublishdate) {
		this.endpublishdate = endpublishdate;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Object MapToModel(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Job job = new Job();
		
		try {
			job.refjob = resultSet.getString("refjob");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
		
	}
	
	public String GetDatabaseTableName() {
		// TODO Auto-generated method stub
		return "job";
	}
	
	
}
