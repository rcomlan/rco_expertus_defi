package rco.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class User 
{
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String phone;
	private String profil;
	private byte[] resume;
	
	// Job applications for an user
	public List <JobApplication> jobApplications;
	
	public User() 
	{
		jobApplications = new ArrayList<JobApplication>();
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getFirstname() 
	{
		return firstname;
	}
	
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public String getLastname() 
	{
		return lastname;
	}
	
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	
	
	
}
