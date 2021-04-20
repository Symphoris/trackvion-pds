package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AccountType;
import business.AlertsDetails;
import business.ConnectAccount;
import business.ResidentForm;
import business.ResidentsInformation;
import common.Configuration;
import common.NotifierHandler;


public class SearchResidentServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		public SearchResidentServlet() {
			super();
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if((Integer)request.getAttribute("isIdentified") != 2) {
				response.sendRedirect("/tv/connect");
				return;
			}

			request.setAttribute("residents",new ResidentForm().getResidents() );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/searchResidents.jsp" ).forward( request, response );
	
		    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		try {
			if (request.getParameter("name")!="" ) {

			request.setAttribute("results",new ResidentsInformation().toString(request.getParameter("name")) );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/searchResidents.jsp" ).forward( request, response );
			}
			else {
				String answer="<h2>  !!!!!!!!!! No Resident associated to this Lastname and firstName  !!!!!!!!!! </h2> ";
				request.setAttribute("results", answer);
				this.getServletContext().getRequestDispatcher( "/WEB-INF/searchResidents.jsp" ).forward( request, response );
			}

		}catch(Exception e) {
			NotifierHandler.setNotifierMessage(request, e.getMessage());
			this.getServletContext().getRequestDispatcher( "/WEB-INF/searchResidents.jsp" ).forward( request, response );
		}
	}

		}
	

