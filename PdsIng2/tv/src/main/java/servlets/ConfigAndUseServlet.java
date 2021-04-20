package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ConnectedObject;
import beans.ConnectedObjects;
import business.MapAppatments;
import business.MapOC;
import business.map.AlertsService;
import business.map.Map;
import common.NotifierHandler;

/**
 * Servlet implementation class ListEmployeesServlet
 */
public class ConfigAndUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigAndUseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("tototot");
		Integer apartmentId;
		
		try {
			apartmentId = Integer.parseInt(request.getPathInfo().substring(1));
			System.out.println(apartmentId);
			request.setAttribute("map", new MapOC(apartmentId));
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/utilisation.jsp");
			view.forward(request, response);
			
		} catch (Exception e) {
			NotifierHandler.setNotifierMessage(request, e.getMessage());
			response.sendRedirect("/tv/apartmentOC"); 
			return;
		} 
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("tototot2");
		Integer apartmentId;
		
		try {
			apartmentId = Integer.parseInt(request.getPathInfo().substring(1));
			System.out.println("apartmentId");
			request.setAttribute("map", new MapOC(apartmentId));
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/utilisation.jsp");
			view.forward(request, response);
			
		} catch (Exception e) {
			NotifierHandler.setNotifierMessage(request, e.getMessage());
			response.sendRedirect("/tv/apartmentOC"); 
			return;
		} 
		
//		try {
//			
//		  if(request.getParameter("objectId") != null) {
//				Integer id = Integer.parseInt(request.getParameter("objectId"));
//				ConnectedObjects object = new ConnectedObjects(id);
//				//request.setAttribute("map", new MapOC(id));
//			
//				Integer locatedApartId;
//				try {
//					locatedApartId = Integer.parseInt(request.getParameter("apartmentId"));
//				}catch (NumberFormatException nfe) {
//					doGet(request,response);
//					return;
//				}
//				request.setAttribute("map", new MapAppatments(locatedApartId));
//				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/apartmentOC.jsp");
//				view.forward(request, response);
//				
//			}
//		}catch(Exception e) {
//			NotifierHandler.setNotifierMessage(request, "An error occured during the process");
//		}
//		
		
	}

}
