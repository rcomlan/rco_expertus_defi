package rco.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rco.springmvc.model.User;
import rco.springmvc.service.JobService;
import rco.springmvc.service.UserService;

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
	    // Return an object View with blank fields (user)
	    return modelandview;
	}
	
	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) 
	{
		ModelAndView modelandview = null;
		
		
////		// Retrieve the added user informations to load the welcome page
//		User user_added = userService.getUserInfo(username, password);
//		modelandview.addObject("username", user_added.getUsername());
//    	modelandview.addObject("firstname", user_added.getFirstname());
//    	modelandview.addObject("lastname", user_added.getLastname());
//    	modelandview.addObject("profil", user_added.getProfil());
		return modelandview;
	}
	
}
