package rco.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rco.springmvc.model.User;
import rco.springmvc.model.Job;
import rco.springmvc.service.JobService;
import rco.springmvc.service.UserService;
import rco.springmvc.service.UserServiceImpl;
import rco.springmvc.service.JobServiceImpl;

@Controller
public class SignUpController {
		
	@Autowired
	public UserService userService;
	
	@Autowired
	public JobService jobService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignUp(HttpServletRequest request, HttpServletResponse response) 
	{
	    ModelAndView modelandview = new ModelAndView("signup");
	    modelandview.addObject("user", new User());
	    // Retourne un objet View qui est la liste des champs vides d'un user
	    return modelandview;
	}
	
	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) 
	{
		ArrayList<Job> jobs;
		ModelAndView modelandview;
		userService = new UserServiceImpl();
		if (user.getUsername().toLowerCase().equals("admin"))
		{
			userService.signup(user, "Administrator");
			modelandview = new ModelAndView("welcome");
		}
		else 
		{
			userService.signup(user);
			jobService = new JobServiceImpl();
			jobs = new ArrayList<Job>();
			jobs = jobService.getJobsList("Opened");
			
			// Redirect the new user to Careers page
			modelandview = new ModelAndView("careers");
			for (int i=0 ; i < jobs.size(); i++)
	    	{
	    		modelandview.addObject("job", jobs.get(i));
	    	}
		}
		// Retrieve the added user informations to load the welcome page
		User user_added = userService.getUserInfo(user.getUsername(), user.getPassword());
		modelandview.addObject("username", user_added.getUsername());
    	modelandview.addObject("firstname", user_added.getFirstname());
    	modelandview.addObject("lastname", user_added.getLastname());
    	modelandview.addObject("profil", user_added.getProfil());
		return modelandview;
	}
	
}
