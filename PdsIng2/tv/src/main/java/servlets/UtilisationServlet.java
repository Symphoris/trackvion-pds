package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.MapAppatments;
import business.map.Map;

public class UtilisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		request.setAttribute("map", new MapAppatments());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/apartmentOC.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer locatedApartId;
		try {
			locatedApartId = Integer.parseInt(request.getParameter("apartmentId"));
		}catch (NumberFormatException nfe) {
			doGet(request,response);
			return;
		}
		request.setAttribute("map", new MapAppatments(locatedApartId));
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/apartmentOC.jsp");
		view.forward(request, response);

	}
}
