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

@Controller
public class SignInController {
	
	@Autowired
	UserService userAuthService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView modelandview = new ModelAndView("signin");
		modelandview.addObject("signin", new Login());
	    return modelandview;
	}
	
	
	@RequestMapping(value = "/signInProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("signin") Login unLogin) 
	{
	    ModelAndView modelandview = null;
	    
	    User user = userAuthService.validateUser(unLogin);
	    
	    if (null != user) 
	    {
	    	modelandview = new ModelAndView("Hello");
	    	modelandview.addObject("firstname", user.getFirstname());
	    } 
	    else 
	    {
	    	modelandview = new ModelAndView("signin");
	    	modelandview.addObject("message", "Please check the username and password !!");
	    }
	    
	    return modelandview;
	    
	  }
}