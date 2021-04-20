package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CandidateList;
import business.EmployeesList;
import business.map.Map;

/**
 * Servlet implementation class CandidateList
 */

public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateListServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((Integer)request.getAttribute("isIdentified") != 2) {
			
			response.sendRedirect("/tv/connect"); 
			return;
		}
		CandidateList list = new CandidateList();
		

		if((String) request.getParameter("sante")!=null && (String)request.getParameter("finance")!=null ) {
			Integer sante = Integer.parseInt((String)request.getParameter("sante"));
			Integer finance = Integer.parseInt((String)request.getParameter("finance"));
			if (sante != null && finance != null) {
				if((sante+finance)==100 ) {
					request.setAttribute("linesTable",list.updatadeNoteGlobale(sante, finance));
				}
				else {
					request.setAttribute("optionalMessage", "la somme des coefficients doit être égale à 100 :(<br>");
				}
				request.setAttribute("financeCoef", finance);
				request.setAttribute("santeCoef", sante);
			}
		
		}		
		else {
			request.setAttribute("financeCoef", 50);
			request.setAttribute("santeCoef", 50);
			request.setAttribute("linesTable",list.getCandidateTableLines());
		}
		

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/candidatelist.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if((Integer)request.getAttribute("isIdentified") != 2) {
			// The user must be an administrator identified
			response.sendRedirect("/tv");
			return;
		}
		
		CandidateList list = new CandidateList();
		
		if(list.deleteCandidate(request.getParameter("id")))
			request.setAttribute("optionalMessage", "The candidate was deleted!<br>");
	    else
	    	request.setAttribute("optionalMessage", "A problem occured during the process :(<br>");
		
		request.setAttribute("linesTable",list.getCandidateTableLines());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/candidatelist.jsp");
		view.forward(request, response);
	}

}
