package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Resident;
import common.Configuration;
public class ResidentForm {

	private String firstname;
	private String lastname;
	private String email;
	private  ArrayList<Resident> residents;

	public ResidentForm(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public boolean executeInscription() {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into Residents(Login_Resident, Password_Resident, Lastname_Resident, Firstname_Resident, Age_Resident, Information_Resident, ID_Apartment) values (?,?,?,?,?,?,?);");
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, email); 
			//TODO
			stmt.executeUpdate();
			Configuration.connectionPool.closeConnection(connection);	
		} catch (Exception e) {
			Configuration.connectionPool.closeConnection(connection);	
			return false;
		}
		return true;
	}
	
	public void getResident() {
		residents = new ArrayList<Resident>();
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Residents");
			ResultSet result = stmt.executeQuery();
			while(result.next()) { 
				residents.add(new Resident(result));
			}
			Configuration.connectionPool.closeConnection(connection);	
		} catch (Exception e) {
			Configuration.connectionPool.closeConnection(connection);	
			
		}
		
	}
	
	
	public ResidentForm() {
		
	}
	public String getResidents() throws IOException {
		
		getResident();
		String residentForm ="";
		try {
		for (int i=0 ; i< residents.size(); i++) {
		residentForm +="<option>"+ residents.get(i).getFirstName() + "  " + residents.get(i).getLastName() ;
		}} catch (Exception e) {}
 		return residentForm  ;
		
	}
	}



