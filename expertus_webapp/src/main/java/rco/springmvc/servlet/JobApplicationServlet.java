package rco.springmvc.servlet;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import rco.springmvc.service.JobService;
import rco.springmvc.service.JobServiceImpl;

/**
 * Servlet implementation class JobApplicationServlet
 */
@WebServlet(name = "JobApplicationServlet", urlPatterns = {"/apply"})
public class JobApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private JobService jobService;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("----- Get Request for /thanks ---------");
		response.setStatus(HttpServletResponse.SC_FOUND);//302
	    response.setHeader("Location", "http://localhost:8080/expertus_webapp/careers/{username}/thanks");
	}

	/**
	 * @param username 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String [] selected = request.getParameterValues("selected");
		
		// Some jobs have been selected
	    if (selected != null) 
	    {
			jobService = new JobServiceImpl();
			String refjob = null;
			for (int i = 0; i < selected.length; i++)
			{
				refjob = selected[i].toString();
				System.out.println("Refjob : ");
				System.out.println(refjob);
				jobService.addJobApplication(username, refjob);
			}
			doGet(request, response);
	    }
	    else
	    {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);//400
		    response.setHeader("Location", "http://localhost:8080/expertus_webapp/careers/{username}");
	    }
   	
	}

}
