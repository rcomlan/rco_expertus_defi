package rco.restapi.service;

import rco.restapi.repository.RepositoryFactory;

public class JobService 
{
	
	private RepositoryFactory repositoryFactory;
	
	public JobService(RepositoryFactory p_repositoryFactory)
	{
		this.repositoryFactory = p_repositoryFactory;
	}
	
	public void AddJob(String refjob, String url, String datepublish, String endpublishdate, String jobtitle, String level, Double salary)
	{
		this.repositoryFactory.Job().addJob(refjob, url, datepublish, endpublishdate, jobtitle, level, salary);
	}

}
