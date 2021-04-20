package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ResidentForm;
import business.TrackResident;

public class TrackResidentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public TrackResidentServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if((Integer)request.getAttribute("isIdentified") != 2) {
			// The user must be an administrator identified
			response.sendRedirect("/tv/connect"); 
			return;
		}
	
	
		request.setAttribute("residents", new ResidentForm().getResidents());
		request.setAttribute("positionX", new TrackResident().getData(1));
		request.setAttribute("positionY", new TrackResident().getData(2));
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/trackresident.jsp");
		view.forward(request, response);

	}
}
