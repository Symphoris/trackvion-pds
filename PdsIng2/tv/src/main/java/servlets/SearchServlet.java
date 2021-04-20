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



public class SearchServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		public SearchServlet() {
			super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if((Integer)request.getAttribute("isIdentified") != 2) {
				response.sendRedirect("/tv/connect");
				return;
			}
			
			request.setAttribute( "data",new ResidentsInformation().getDataCharts());
			this.getServletContext().getRequestDispatcher( "/WEB-INF/data.jsp" ).forward( request, response );
	
		    }
}
