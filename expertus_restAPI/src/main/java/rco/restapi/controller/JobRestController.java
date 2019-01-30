package rco.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rco.restapi.model.Job;
import rco.restapi.service.JobService;

@RestController
public class JobRestController extends BaseController {
	private JobService jobService;
	private Job toApply;
	//public static final String WEB_HOST = "http://localhost:8000";
	//public static final JsonObject objetJson = null;
	
	
	//@Autowired
	JobRestController() {
		super();
		this.jobService = new JobService(super._repositoryFactory);
	}

	
	
	@RequestMapping(value = "/jobs/available")
	  public ResponseEntity<List<Job>> GetAvailableJobs() {

		List<Job> jb =  super._repositoryFactory.Job().GetAvailableJobs();
		
		String json = new Gson().toJson(jb);
		return ResponseEntity
	            .ok()
	            .body(jb);
	  }
	
	@RequestMapping(value = "/jobs/closed")
	  public ResponseEntity<List<Job>> GetClosedJobs() {

		List<Job> jb =  super._repositoryFactory.Job().GetClosedJobs();
		
		String json = new Gson().toJson(jb );
		return ResponseEntity
	            .ok()
	            .body(jb);
	  }
	
	  @RequestMapping(value = "/job")
	  public void addJob(String refjob, String url, String datepublish, String endpublishdate, String jobtitle, String level, Double salary) 
	  {
		  super._repositoryFactory.Job().addJob(refjob, url, datepublish, endpublishdate, jobtitle, level, salary);		
	  }
	
}