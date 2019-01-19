package rco.springmvc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import rco.springmvc.service.UserService;

public class SignInServlet extends HttpServlet
{
	
	@Autowired
	UserService userAuthService;
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
				
		if(userAuthService.checkUserAuthentification(username, password) == true)
		{
			session.setAttribute("OKForNavigation", true);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(req, res);
		} 
		else 
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(req, res);
		}
	}
}