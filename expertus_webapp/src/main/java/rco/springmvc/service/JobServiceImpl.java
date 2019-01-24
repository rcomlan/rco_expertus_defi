package rco.springmvc.service;

import java.sql.Blob;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import rco.springmvc.dao.JobApplicationDAOImpl;
import rco.springmvc.dao.JobDAOImpl;
import rco.springmvc.model.Job;

public class JobServiceImpl implements JobService
{

	@Autowired
	private JobDAOImpl jobDAOImpl;
	
	@Autowired
	private JobApplicationDAOImpl jobApplicationDAOImpl;
	
	public JobServiceImpl() 
	{
		this.jobDAOImpl = new JobDAOImpl();
	}
	
	public JobServiceImpl(JobDAOImpl jobDAOImpl) 
	{
		this.jobDAOImpl = jobDAOImpl;
	}

	@Override
	public ArrayList<Job> getJobsList(String status) 
	{
		ArrayList<Job> jobs = jobDAOImpl.getJobsList(status);
		return jobs;
	}

	@Override
	public Job getJob(String refjob) 
	{
		return jobDAOImpl.getJob(refjob);
	}

	@Override
	public void addJobApplication(String username, String refjob, String availability_date, Blob resume) 
	{
		jobApplicationDAOImpl.addJobApplication(username, refjob, availability_date, resume);
	}
}
