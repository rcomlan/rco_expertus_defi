package rco.springmvc.model;

import java.util.ArrayList;

public class Job 
{
	
	private String refjob;
	private String datepublish;
	private String endpublishdate;
	private String jobtitle;
	private String level;
	private Double salary;
	private String status;
	private ArrayList <Job> jobs;
	
	public Job() {
		
	}

	public Job(String refjob, String datepublish, String endpublishdate, String jobtitle, String level, Double salary,
			String status) {
		super();
		this.refjob = refjob;
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

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	
	
	
	
}
