package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.AlertsDetails;
import business.NotificationsService;


public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public NotificationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if((Integer)request.getAttribute("isIdentified") != 2) {
			response.sendRedirect("/tv/connect");
			return;
		}


		request.setAttribute( "notif", new NotificationsService().getInformations ());
		request.setAttribute( "message",new NotificationsService().getNotifications());
		this.getServletContext().getRequestDispatcher( "/WEB-INF/notification.jsp" ).forward( request, response );
	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer  alertId, alertId2 = null;
		try {
		
		if(request.getParameter("alertId") != null) {
			alertId = Integer.parseInt(request.getParameter("alertId"));
			deleteNotification(alertId,request,response);
		}
		
		else  if (request.getParameter("alertDetails") != null) {
			 alertId2 = Integer.parseInt(request.getParameter("alertDetails"));
				showDetails(alertId2,request,response);
		} 
		}
		catch(Exception e) {}
				
	}
	
	// close the alert when we clic on close button
	public void deleteNotification(int alertId,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		 try {
		AlertsDetails alert = new AlertsDetails();
		alert.setStateAlert(alertId);
		  
	}catch (NumberFormatException nfe) {
		return;
	}
		 doGet(request,response);

	}
	
	// show details when we clic on details button 
	public void showDetails(int alertId2,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	try {}
	catch(Exception e) {
		doGet(request,response);
		return;
	}
    request.setAttribute("details",  new AlertsDetails(alertId2).toString());
    this.getServletContext().getRequestDispatcher( "/WEB-INF/notification.jsp" ).forward( request, response );
	}

}
