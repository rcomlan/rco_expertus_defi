package rco.restapi.controller;

import rco.restapi.model.Job;
import rco.restapi.service.JobApplicationService;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

public class JobApplicationRestController extends BaseController 
{
	private JobApplicationService jobApplicationService;
	private ArrayList <Job> _jobsApplied;
	
	//@Autowired
		JobApplicationRestController() {
			super();
			this.jobApplicationService = new JobApplicationService(super._repositoryFactory);
		}
		
	  @RequestMapping(value = "/jobapplication/applied")
	  public ResponseEntity<List<Job>> GetAppliedJobs() {
	
		List<Job> jobs =  super._repositoryFactory.JobApplication().GetAppliedJobs();
		
		String json = new Gson().toJson(jobs);
		return ResponseEntity
	            .ok()
	            .body(jobs);
	  }
	  
	//@RequestMapping(method = RequestMethod.GET)
		@RequestMapping(value = "user/{username}/job_application/", method = RequestMethod.GET,  produces = "application/json;charset=UTF-8")
		  public ResponseEntity<List<Job>> GetAppliedJobsforAnUser(@PathVariable String username, @RequestBody String input) {
			
			JSONObject _rootJson = new JSONObject(input);
			JSONArray _arrayJson =new JSONArray(_rootJson.get("jobApplications").toString());
			
			_jobsApplied = new ArrayList <Job>();
			
			for (int i=0; i<_arrayJson.length(); i++) 
			{
				Job unJob = new Job();
				unJob.setRefjob(_arrayJson.getJSONObject(i).get("refjob").toString());
				unJob.setDatepublish(_arrayJson.getJSONObject(i).get("datepublish").toString());
				unJob.setEndpublishdate(_arrayJson.getJSONObject(i).get("endpublishdate").toString());
				unJob.setJobtitle(_arrayJson.getJSONObject(i).get("jobtitle").toString());
				unJob.setLevel(_arrayJson.getJSONObject(i).get("level").toString());
				unJob.setSalary(Double.parseDouble(_arrayJson.getJSONObject(i).get("salary").toString()));
				unJob.setStatus(_arrayJson.getJSONObject(i).get("status").toString());
				_jobsApplied.add(unJob);
			}
			
			String json = new Gson().toJson(_jobsApplied);
			return ResponseEntity
					.ok()
					.body(_jobsApplied);
		  }
}
