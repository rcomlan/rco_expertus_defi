package rco.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView backHome(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	

}
