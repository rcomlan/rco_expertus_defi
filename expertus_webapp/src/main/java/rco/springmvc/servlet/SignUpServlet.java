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

public class SignUpServlet extends HttpServlet
{
	
	@Autowired
	UserService userAuthService;
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || email.isEmpty())
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(req, res);
		}
		else
		{
			userAuthService.createUser(username, password, firstname, lastname, email, address, phone);
			session.setAttribute("OKForNavigation", true);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(req, res);
		}
	}

}
