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
import rco.springmvc.service.UserService;
import rco.springmvc.service.UserServiceImpl;

@Controller
public class SignUpController {
	
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignUp(HttpServletRequest request, HttpServletResponse response) 
	{
	    ModelAndView modelandview = new ModelAndView("signup");
	    modelandview.addObject("user", new User());
	    return modelandview;
	}
	
	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) 
	{
		userService = new UserServiceImpl();
		userService.signup(user);
		ModelAndView modelandview = new ModelAndView("welcome");
		modelandview.addObject("username", user.getUsername());
    	modelandview.addObject("firstname", user.getFirstname());
    	modelandview.addObject("lastname", user.getLastname());
		return modelandview;
	}
	
}
