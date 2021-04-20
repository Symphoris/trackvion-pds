package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.NotificationsService;
import business.ResidentForm;
import business.ResidentsInformation;


public class HealthServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		public HealthServlet() {
			super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if((Integer)request.getAttribute("isIdentified") != 2) {
				response.sendRedirect("/tv/connect");
				return;
			}

			request.setAttribute( "health", new NotificationsService().getAlert());
			request.setAttribute( "notif", new NotificationsService().getInformations ());
			this.getServletContext().getRequestDispatcher( "/WEB-INF/health.jsp" ).forward( request, response );
	
		    }
	}
