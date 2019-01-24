package rco.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/careers", method = RequestMethod.GET)
	public ModelAndView showCareers(HttpServletRequest request, HttpServletResponse response) 
	{
	    ModelAndView modelandview = new ModelAndView("jobapplication");
	    modelandview.addObject("user", new User());
	    
	    jobService = new JobServiceImpl();
	    modelandview.addObject("job", jobService.getJobsList("Opened"));
	    
	    return modelandview;
	}
	
	@RequestMapping(value = "/careers/{refjob}/", method = RequestMethod.GET)
	public ModelAndView showACareer(HttpServletRequest request, HttpServletResponse response, String refjob) 
	{
	    ModelAndView modelandview = new ModelAndView("jobapplication");
	    modelandview.addObject("user", new User());
	    
	    jobService = new JobServiceImpl();
	    modelandview.addObject("job", jobService.getJob(refjob));
	    
	    // Retourne l'interface du job recherché
	    return modelandview;
	}
	
	@RequestMapping(value = "/user/{username}/careers/{refjob}/apply", method = RequestMethod.POST)
	public ModelAndView addJobApplication(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("job_application") JobApplication jobapplication, String refjob, String username) 
	{		
		ModelAndView modelandview;
		userService = new UserServiceImpl();
		User user = userService.getUserInfo(username);
		
		if (user.getUsername().toLowerCase().equals("admin")) modelandview = new ModelAndView("welcome");
		else 
		{
			modelandview = new ModelAndView("thanks");
		    modelandview.addObject("job_application", new JobApplication());
		    jobService = new JobServiceImpl();
		    jobService.addJobApplication(username, refjob, jobapplication.getAvailability_date(), jobapplication.getResume());
		    String confirmation = (username + refjob).toUpperCase();
		    modelandview.addObject("confirmation", confirmation);
		}
		modelandview.addObject("username", user.getUsername());
    	modelandview.addObject("firstname", user.getFirstname());
    	modelandview.addObject("lastname", user.getLastname());
    	modelandview.addObject("profil", user.getProfil());
	
		return modelandview;
	}	
}
