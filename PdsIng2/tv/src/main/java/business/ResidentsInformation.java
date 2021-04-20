package business;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Apartment;
import beans.HistoricalMedicalData;
import beans.Resident;
import common.Configuration;

public class ResidentsInformation {
	private Resident resident;
	private Apartment apartment;
	private ArrayList<HistoricalMedicalData> data;
	
	
	public ResidentsInformation() {
		
	}
	
	//Split the content of input and get informations of residents by firstName and LastName
public void getInformations(String name) {
	String lastName;
	String firstName;
	
      String[] arrOfname = name.split(" "); 
      firstName=arrOfname[0];
      lastName = arrOfname[1];
      try {
		residentDetails( firstName,  lastName);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

//Get informations residents 
public void residentDetails(String firstName, String lastName) throws IOException {
	
	Connection connection = Configuration.connectionPool.getConnection();
	
	try {
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Residents WHERE Lastname_Resident=? AND Firstname_Resident=?;");
		stmt.setString(1, lastName);
		stmt.setString(2, firstName);
		ResultSet result = stmt.executeQuery();
		if(!result.next())
			throw new Exception("No Resident associated to this Lastname and firstName");
		resident = new Resident(result);
		apartmentDetails(resident.getApartment());
		Configuration.connectionPool.closeConnection(connection);
	}
	catch(Exception e) {
		Configuration.connectionPool.closeConnection(connection);
		throw new IOException("An error occured while retrieving the Resident informations : " + e.getMessage());
	}
}

//Get apartments details related to the resident 
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

//Medicals data 
public void  dataDetails() throws IOException {
	data = new ArrayList<HistoricalMedicalData>();
	Connection connection = Configuration.connectionPool.getConnection();
	try {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM HistoricalMedicalData ;");

		ResultSet result = stmt.executeQuery();
		if(!result.next())
			throw new Exception("No Data In the table");
		while(result.next()) {
	
				data.add(new HistoricalMedicalData(result));
	}
			Configuration.connectionPool.closeConnection(connection);
	}
	catch(Exception e) {
		Configuration.connectionPool.closeConnection(connection);
		throw new IOException("An error occured while retrieving the data  : " + e.getMessage());
	}
}



public String toString(String name) {
	 getInformations( name);
     
	String results = "";
	
	results += "<label >" +"FirstName  : "+"</label>";
	results += "<input type='text2'  placeholder='"+ resident.getFirstName()+"'><br>";
	results += "<label >" +"LastName  : "+"</label>";
	results += "<input type='text2'  placeholder='"+ resident.getLastName()+"'><br>";
	results += "<label >" +"Age  : "+"</label>";
	results += "<input type='text3'  placeholder='"+ resident.getAge()+"'><br>";
	results += "<label>" +"Apartment  : "+"</label>";
	results += "<input type='text2'  placeholder='"+ apartment.getName()+"'><br>";
	results += "<label >" +"Informations  : "+"</label>";
	results += "<input type='text2'  placeholder='"+ resident.getInformation()+"'><br>";
	results += "<a  href='/tv/data' class = 'icon1' title='Data Visualisation '>   <img src='https://img.icons8.com/officel/60/000000/edit-graph-report.png'>Data Visualisation</a>";
	results += "<a  href='/tv/data' class = 'icon2' title='Historical Medical Data '>  <img src='https://img.icons8.com/office/80/000000/historical.png'>Historical</a>";
return results;
}

public void getMedicalData() {

	try {

	dataDetails();
	
	} catch(Exception e) {
		
	}
	
}
// get MedicalData to draw a charts 
public String getDataCharts() {
	String dataChart="";
	getMedicalData();
	
	for(int i=0; i<data.size(); i++) {
	 dataChart+= data.get(i).getDate()+","+data.get(i).getData()+",";
	}
	return dataChart;
}

}
