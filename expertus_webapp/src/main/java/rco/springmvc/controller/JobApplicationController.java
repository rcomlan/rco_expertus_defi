package rco.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rco.springmvc.model.Job;
import rco.springmvc.model.JobApplication;
import rco.springmvc.model.User;
import rco.springmvc.service.JobService;
import rco.springmvc.service.JobServiceImpl;
import rco.springmvc.service.UserService;
import rco.springmvc.service.UserServiceImpl;

@Controller
public class JobApplicationController 
{
	
	@Autowired
	public JobService jobService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/careers/{username}", method = RequestMethod.GET)
	public ModelAndView showCareers(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("job") Job job, @PathVariable("username") String username) 
	{
		// Create a View Object careers with unLogin Model data
		ModelAndView modelandview = null;
		
		/* Retrieve the parameter username from the previous form (signin.jsp)
		 * Will be used to load user informations into the View careers
		 * */
	    userService = new UserServiceImpl();
	    User loggedUser = userService.getUserInfo(username);
	    
	    if (loggedUser != null)
	    {
	    	modelandview = new ModelAndView("careers");
	    	modelandview.addObject("username", loggedUser.getUsername());
	    	modelandview.addObject("firstname", loggedUser.getFirstname());
	    	modelandview.addObject("lastname", loggedUser.getLastname());
	    	modelandview.addObject("profil", loggedUser.getProfil());
		    
			jobService = new JobServiceImpl();
	    	ArrayList<Job> jobs = new ArrayList<Job>();
	    	jobs = jobService.getJobsList("Opened");   
		    modelandview.addObject("jobs", jobs);
	    }
    	
	    return modelandview;
	}
	
	@RequestMapping(value = "/careers/{username}/thanks", method = RequestMethod.GET)
	public ModelAndView showConfirmation(HttpServletRequest request, HttpServletResponse response, 
	@ModelAttribute("jobapplication") JobApplication jobapplication, @PathVariable("username") String username) 
	{
	    ModelAndView modelandview = new ModelAndView("thanks");
//	    userService = new UserServiceImpl();
//	    User loggedUser = userService.getUserInfo(username);
//	    modelandview.addObject("username", loggedUser.getUsername());
//    	modelandview.addObject("firstname", loggedUser.getFirstname());
//    	modelandview.addObject("lastname", loggedUser.getLastname());
//    	modelandview.addObject("profil", loggedUser.getProfil());
	    return modelandview;
	}
	
	@RequestMapping(value = "/careers/{username}/applyProcess", method = RequestMethod.POST)
	public ModelAndView addJobApplication(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("jobapplication") JobApplication jobapplication, @PathVariable("username") String username) 
	{		
		return null;
	}	
}
