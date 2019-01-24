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

import rco.springmvc.model.Login;
import rco.springmvc.model.User;
import rco.springmvc.model.Job;
import rco.springmvc.service.JobService;
import rco.springmvc.service.JobServiceImpl;
import rco.springmvc.service.UserService;
import rco.springmvc.service.UserServiceImpl;

@Controller
public class SignInController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobService jobService;
				
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView modelandview = new ModelAndView("signin");
		modelandview.addObject("login", new Login());
		// Retourne une View qui est la liste des champs vides (username, password) requis pour se connecter
	    return modelandview;
	}
	
	
	@RequestMapping(value = "/signInProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("login") Login unLogin) 
	{
	    ModelAndView modelandview = null;
	    
	    userService = new UserServiceImpl();
	    User user = userService.validateUser(unLogin);
	    
	    if (null != user) 
	    {
	    	if (!user.getUsername().toLowerCase().equals("admin"))
			{
	    		// Redirige vers la page d'affichage des postes disponibles
	    		modelandview = new ModelAndView("careers");
		    	modelandview.addObject("username", user.getUsername());
		    	modelandview.addObject("firstname", user.getFirstname());
		    	modelandview.addObject("lastname", user.getLastname());
		    	modelandview.addObject("profil", user.getProfil());
		    	
		    	jobService = new JobServiceImpl();
		    	ArrayList<Job> jobs = new ArrayList<Job>();
		    	jobs = jobService.getJobsList("Opened");
		    	for (int i=0 ; i < jobs.size(); i++)
		    	{
		    		modelandview.addObject("job", jobs.get(i));
		    	}
			}
	    	else
	    	{
	    		// Redirige l'administrateur vers la page Welcome
	    		modelandview = new ModelAndView("welcome");
		    	modelandview.addObject("username", user.getUsername());
		    	modelandview.addObject("firstname", user.getFirstname());
		    	modelandview.addObject("lastname", user.getLastname());
		    	modelandview.addObject("profil", user.getProfil());
	    	}
	    } 
	    else 
	    {
	    	modelandview = new ModelAndView("signin");
	    	modelandview.addObject("message", "Please check the username and password !!");
	    }
	    
	    return modelandview;
	  }
}