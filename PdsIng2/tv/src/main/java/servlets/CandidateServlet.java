package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Candidate;
import beans.Questionnary;
import business.CandidateForm;
import business.ProfilService;
import business.ResidentForm;
import common.Configuration;

/**
 * Servlet implementation class addEmployeeServlet
 */
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/candidate.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		Candidate candidate = new Candidate();
		candidate.setCivility(request.getParameter("civility"));
		String a = request.getParameter("age");
		int age = Integer.parseInt(a);
		candidate.setAge(age);
		System.out.println(a);
		candidate.setFirstname(request.getParameter("firstname"));
		candidate.setLastname(request.getParameter("lastname"));
		candidate.setEmail(request.getParameter("email"));
		candidate.setPassword(request.getParameter("password"));
		CandidateForm candidateForm = new CandidateForm(candidate);
		Questionnary questionnary = new Questionnary();
		
	    if(candidateForm.executeInscription()) {
	    	request.setAttribute("optionalMessage", "succesfull inscription!");
	    	//RequestDispatcher view = request.getRequestDispatcher("/questionnary");
			//view.forward(request, response);
	    	//ProfilService profilService = new ProfilService(questionnary, candidate);
	    	
	    	
	    	
	    	
	        HttpSession session = request.getSession();
	        session.setAttribute("firstname", request.getParameter("firstname"));
	        session.setAttribute("lastname", request.getParameter("lastname"));
	       
	        session.setAttribute("age", request.getParameter("age"));
	    	response.sendRedirect("/tv/questionnary");
	    }
	    else
	    	request.setAttribute("optionalMessage", "A problem occured during the process :("); 
	    
	}

}


