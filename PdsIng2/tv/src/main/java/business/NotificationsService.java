package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import beans.MedicalAlerts;
import common.Configuration;

public class NotificationsService {
	
	private static int numberAlerts;
	public  ArrayList<MedicalAlerts> showedNotification;
	public static ArrayList<MedicalAlerts> listAlerts;
	private HashMap<Integer,MedicalAlerts> map;
	

	public NotificationsService() {	
	}
	

	//get number of alert from table MedicalAlert 
	public static int getNbAlerts() {
		Connection connection = Configuration.connectionPool.getConnection();
		 try {
			      PreparedStatement stmt = connection.prepareStatement("Select count(*) as nbAlert from MedicalAlerts  "
			  		+" INNER JOIN Objects ON MedicalAlerts.ID_Object = Objects.ID_Object  "
			        +" WHERE State_Alert = 1;");
		      //Result of sql
		      ResultSet result = stmt.executeQuery();
		      while(result.next()){            
		          numberAlerts = result.getInt("nbAlert");
		          }
		      result.close();
		      stmt.close();
		      Configuration.connectionPool.closeConnection(connection);
		    } catch (Exception e) {
		    	Configuration.connectionPool.closeConnection(connection);
		      e.printStackTrace();
		    }   
		return numberAlerts;
	}
	
	//Create a  message of notification from Alert List
	public String getInformations () throws IOException  {
		
		getNotification();
		String message;
		String notification="";
		
	      try {      	  
		for (int i=0 ; i<showedNotification.size(); i++) {
			message=showedNotification.get(i).getMessage();
			notification+=  "<div class='notify1'>";
			notification+=  "<p>"+message+"</p>";
			notification+=  "<small>"+ showedNotification.get(i).getDate() +"</small>";
			notification+=  "</div>";
			setStateNotification(showedNotification.get(i).getId());
		}
	      }catch(Exception e) {}   
		return notification;
	}
	
	// Show Alert number, if number==0(No alert ) green color and no animation else (Alert) Red color with animation (warning)
	public String getAlert() {
		
		String alert="";
		int nbAlerts = getNbAlerts();
		
		if ( nbAlerts!= 0) {
		alert +=  "<a href='/tv/notification' class='notification1'>";
		alert +=  "<span> Alerts </span>";
		alert += "<span class='badge' >";
		alert +=   getNbAlerts();
	    alert += "</span>";
	    alert += "</a>";
		}
		else {
			alert +=  "<a href='/tv/notification' class='noAlert1'>";
			alert +=  "<span> Alerts </span>";
			alert += "<span class='badge'>";
			alert += getNbAlerts();
		    alert += "</span>";
		    alert += "</a>";
		} 
		return alert;
	}
	
	// Identify Level of Alert and show Alerts with different color 
	public String getNotifications() throws IOException{

		getAlerts();
		String notification="";
		String notificationMessage;
		int idAlert ;
		for (Integer index : map.keySet()) {
			  idAlert = map.get(index).getId();
			  notificationMessage = map.get(index).getMessage();
		switch((map.get(index)).getLevel()) {
		case 3 :

			notification +=  "<div class='alert' >";
			notification +=  "!!Danger!!  " + notificationMessage;
			notification += "<form action='' method='post'><input type='hidden' name='alertId' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Close'></div></form>";
			notification += "<form action='' method='post'><input type='hidden' name='alertDetails' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Details'></div></form>"; 
			notification+=  "<small>"+ map.get(index).getDate()  +"</small>";
			notification +=  "</div>";
			
		break;
		
		case 2 :
			 
			notification +=  "<div   class='alert warning' >";
			notification +=  "!!Warning!!  " + notificationMessage;
			notification += "<form action='' method='post'><input type='hidden' name='alertId' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Close'></div></form>";
			notification += "<form action='' method='post'><input type='hidden' name='alertDetails' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Details'></div></form>"; 
			notification+=  "<small>"+ map.get(index).getDate()  +"</small>";
			notification +=  "</div>";
		break;
		
		case 1 :
			
			notification +=  "<div   class='alert malfunction'>";
			notification +=  "!!Malfunctions!!  " + notificationMessage;
			notification += "<form action='' method='post'><input type='hidden' name='alertId' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Close'></div></form>";
			notification += "<form action='' method='post'><input type='hidden' name='alertDetails' value='"+idAlert+"'>" ;
			notification += "<div class='row'><input type='submit' value='Details'></div></form>"; 
			notification+=  "<small>"+ map.get(index).getDate()  +"</small>";
			notification +=  "</div>";
			
		break;
		}
		}	
		return notification;
	}
	
// get list of alert with active  notification  
	public void getNotification() throws IOException {
		showedNotification= new ArrayList<MedicalAlerts>();
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MedicalAlerts WHERE State_Notification=1;");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				showedNotification.add(new MedicalAlerts(result));
			}
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the Alert : " + e.getMessage());
		}
	}
	
//change the state on notification from 1(on) to 0 (off) 
	public void setStateNotification(int id) throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE MedicalAlerts SET State_Notification=0 WHERE ID_Alert=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while updating the state of the Notification : " + e.getMessage());
		}
	}
	
	// get List of active alert (with state 1)
	public void getAlerts()throws IOException {
		
		map= new HashMap<Integer,MedicalAlerts>();
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MedicalAlerts"
					 +" WHERE State_Alert = 1;");
			ResultSet result = stmt.executeQuery();
			Integer idAlert;
			while(result.next()) {
				idAlert = result.getInt(1);		
					map.put(idAlert, new MedicalAlerts(result));
		}
			Configuration.connectionPool.closeConnection(connection);	
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the Alerts : " + e.getMessage());
		}	
	}
	

}

	

