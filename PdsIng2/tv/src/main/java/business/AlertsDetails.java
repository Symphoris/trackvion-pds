package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.Apartment;
import beans.ConnectedObject;
import beans.MedicalAlerts;
import beans.Resident;
import common.Configuration;

public class AlertsDetails {
	
	private MedicalAlerts alert;
	private Apartment apartment;
	private ConnectedObject object;
	private Resident resident;
	
	public AlertsDetails() {	
	}
	
	// Get alert message, and date of creation and residents and apartments information related to Alert_ID
	public  AlertsDetails(int alertId) throws IOException {
		
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MedicalAlerts WHERE ID_Alert=?;");
			stmt.setInt(1, alertId);
			ResultSet result = stmt.executeQuery();
			if(!result.next())
				throw new Exception("No Alert associated to the id");
			alert = new MedicalAlerts(result);
			
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the alert informations : " + e.getMessage());
		}
		try {
		objectDetails(alert.getObjectId()) ;
		residentDetails(object.getApartmentId());
		apartmentDetails(resident.getApartment());
		}catch(Exception e) {
		}
	}
	
	// Get Objects from Id_Objec
	public void objectDetails(int idObject) throws IOException {
		
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Objects WHERE ID_Object=?;");
			stmt.setInt(1, idObject);
			ResultSet result = stmt.executeQuery();
			if(!result.next())
				throw new Exception("No Object associated to the id");
			object = new ConnectedObject(result);
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the Object informations : " + e.getMessage());
		}
	}
	
	// get apartment Details from Apartments table 
	public void apartmentDetails(int idApartment) throws IOException {
		
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Apartments WHERE ID_Apartment=?;");
			stmt.setInt(1, idApartment);
			ResultSet result = stmt.executeQuery();
			if(!result.next())
				throw new Exception("No Apartment  associated to the id");
			apartment = new Apartment(result.getInt(1),result.getString(2),result.getInt(3));
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the Apartments informations : " + e.getMessage());
		}
	}

	// get RedidentDetails from Residents Table
	public void residentDetails(int idApartment) throws IOException {
		
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Residents WHERE ID_Apartment=?;");
			stmt.setInt(1, idApartment);
			ResultSet result = stmt.executeQuery();
			if(!result.next())
				throw new Exception("No Resident associated to the id");
			resident = new Resident(result);
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the Resident informations : " + e.getMessage());
		}
	}
	
	//We update State_alert to off  
	public static void setStateAlert(int idAlert) throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			
			PreparedStatement stmt = connection.prepareStatement("UPDATE MedicalAlerts SET State_Alert=0 WHERE ID_Alert=?");
			stmt.setInt(1, idAlert);
			stmt.executeUpdate();
			
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while updating the state of the Alert : " + e.getMessage());
		}
	}
	// Show alert and resident details
	public String toString() {
		String details = "";
		details +=" Alert: Notify the event ("+ alert.getMessage()+") <br> <br>";
	    details +="Date and time of creation :  "+ alert.getDate()+"<br> <br>";
		details +="Message detail : This alert is generated following an anomaly in the resident's medical data below, the message is:"+alert.getMessage()  +"<br>"; 		  
	    details += "<h3>Resident Information  </h3> ";
		details+=" First Name : "+resident.getFirstName()+"<br>";
	    details+=" Last Name  : "+resident.getLastName()+"<br>";
	    details+="Age        : "+resident.getAge()+"<br>";
	    details+="Apartment      : "+apartment.getName()+"  AT Level :  "+ apartment.getLevel()+"<br>";
	    details +=" More information : "+resident.getInformation()+" <br>";

		return  details;
	}
	
	
	

}