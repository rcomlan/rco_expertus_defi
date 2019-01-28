package rco.springmvc.controller;

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
import rco.springmvc.service.UserService;
import rco.springmvc.service.UserServiceImpl;




@Controller
public class SignInController 
{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView modelandview = new ModelAndView("signin");
		modelandview.addObject("login", new Login());
		
		// Return Login View with blank fields
	    return modelandview;
	}
	
	
	@RequestMapping(value = "/signInProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("login") Login unLogin) 
	{
	    ModelAndView modelandview = null;
	    
	    /* Username and Password verifications
	     * Process only if the user is authorized to access 
	     * to careers/welcome page, else redirect to Login page
	     * */
	    
	    userService = new UserServiceImpl();
	    User user = userService.validateUser(unLogin);
	    	    
	    // User valid
	    if (null != user) 
	    {
	    	if (!user.getUsername().toLowerCase().equals("admin"))
			{
	    		/*Redirect to : 
	    		 * @RequestMapping(value = "/careers", method = RequestMethod.GET)
	    		 * Class : JobApplicationController
	    		 * */
	    		modelandview = new ModelAndView();
	    		modelandview.setViewName("redirect:/careers/{username}");
			}
	    	else
	    	{
	    		// Redirect the Administrator to Welcome page
	    		modelandview = new ModelAndView("welcome");
	    	}	
	    	modelandview.addObject("username", user.getUsername());
	    	modelandview.addObject("firstname", user.getFirstname());
	    	modelandview.addObject("lastname", user.getLastname());
	    	modelandview.addObject("profil", user.getProfil());
	    }
	    else
	    {
	    	// Redirect to login form
	    	modelandview = new ModelAndView("signin");
	    	modelandview.addObject("message", "Please check the username and password !!");
	    }
	    
	    return modelandview;
	}
}