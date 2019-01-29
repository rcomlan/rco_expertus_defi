package rco.springmvc.service;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import rco.springmvc.model.Job;

@Repository
public interface JobService 
{
	ArrayList<Job> getJobsList(String status);
	
	Job getJob(String refjob);
	
	void addJobApplication(String username, String refjob);

}
