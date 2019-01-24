package rco.springmvc.dao;

import java.util.ArrayList;

import rco.springmvc.model.Job;

public interface JobDAO
{
	ArrayList<Job> getJobsList(String status);
	
	Job getJob(String refjob);

}
