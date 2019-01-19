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

@Controller
public class SignUpController {
	//public String[] credentials = new String[2];
	
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignUp(HttpServletRequest request, HttpServletResponse response) 
	{
	    ModelAndView modelanview = new ModelAndView("signup");
	    modelanview.addObject("user", new User());
	    return modelanview;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) 
	{
		userService.register(user);
		//credentials[0] = user.getFirstname();
		//credentials[1] = user.getLastname();
		return new ModelAndView("Hello", "firstname", user.getFirstname());
	}
	
}
