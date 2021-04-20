package business.map;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import beans.ConnectedObject;
import common.Configuration;

public class ResidenceIndicators {

	private ConnectedObject object;
	//	public int nbPannes;
	//	public int tauxPannes;
	private Map<String,Integer> listOfAlerts;
	private Map<String,Integer> listOfMF;
	private ArrayList<ConnectedObject> listObjects;
	private int tauxAlertByType;

	public ResidenceIndicators() throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		String requestSQL = "SELECT * FROM Objects";
		listObjects = new ArrayList<ConnectedObject>();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			while(result.next()) {
				listObjects.add(new ConnectedObject(result));
			}
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while getting the Object list : " + e.getMessage());
		}
		retrieveAlertsByType();
		retrieveMFByType();
		//		retrieveResidentsList();
		//		retrieveObjectsList();
		//		retrieveAlerts();
		//		retrieveMalfunctions();
	}
	
	private void retrieveAlertsByType() throws IOException{
		listOfAlerts = new HashMap<String,Integer>();
		int nbAlert = 0;
		String type;
		Connection connection = Configuration.connectionPool.getConnection();
		String requestSQL = "select type_object, count(*) from Alerts al, Objects ob where al.ID_Object=ob.ID_Object group  by type_object;";

		try {
			// We retrieve the alerts associated to the apartment
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			while(result.next()) {
				type = result.getString(1);
				nbAlert = result.getInt(2);
				listOfAlerts.put(type, nbAlert);
			}  

			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving alert by type of objects : " + e.getMessage());
		}
		 
	}

	private int  retrieveAlerts() throws IOException{ 
		int nbAlertTot = 0;
		Connection connection = Configuration.connectionPool.getConnection();
		String requestSQL = "select count(*) from Alerts"; 
		try { 
			// We retrieve the alerts associated to the apartment
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			result.next();
			nbAlertTot = result.getInt(1); 
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving alert : " + e.getMessage());
		}
		return nbAlertTot; 
	}
	
	private int  retrieveMalfunctions() throws IOException{ 
		int nbMF = 0;
		Connection connection = Configuration.connectionPool.getConnection();
		String requestSQL = "select count(*) from Malfunctions"; 
		try { 
			// We retrieve the alerts associated to the apartment
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			result.next();
			nbMF = result.getInt(1); 
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving alert : " + e.getMessage());
		}
		return nbMF; 
	}
	
	private void retrieveMFByType() throws IOException{
		listOfMF = new HashMap<String,Integer>();
		int nbMF = 0;
		String type;
		Connection connection = Configuration.connectionPool.getConnection();
		String requestSQL = "select type_object, count(*) from Malfunctions mf, Objects ob where mf.ID_Object=ob.ID_Object group  by type_object;";

		try {
			// We retrieve the alerts associated to the apartment
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			while(result.next()) {
				type = result.getString(1);
				nbMF = result.getInt(2);
				listOfMF.put(type, nbMF);
			}  

			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving alert by type of objects : " + e.getMessage());
		}
		 
	}
	

//	public ArrayList<Integer> computeRate() throws IOException{
//		ArrayList<Integer> rateList = new ArrayList <Integer>();
//		for (String e : listOfAlerts.keySet()) {
//			tauxAlertByType	= ((listOfAlerts.get(e))*100/retrieveAlerts());
//			rateList.add(tauxAlertByType);
//		}
//		return rateList;
//	} 
	
	public String displaAlerts() throws IOException{
		String alerts = " ";
		alerts += retrieveAlerts()+" alertes";
		return alerts;
	} 

	public String displaMFs() throws IOException{
		String mf = " ";
		mf += retrieveMalfunctions()+" pannes";
		return mf;
	} 

	public String alertByTypeTable() throws IOException{
		String str ="<h4>Check It</h4>\n";

		if(!listOfAlerts.isEmpty()) {
			//return "<p>Votre liste d'alerte est vide</p>";
		
		str+="<table class='distinguishedAlertTable'><tr><th>Alerts: "+displaAlerts()+"</th></tr></table>\n";
		str+="<table class='distinguishedAlertTable'><tr>\n";
		str+="<td>Object Type</td><td>Number of Alerts</td><td>Alert rate</td>\n";
		str+="</tr>\n";
		
			for (String e : listOfAlerts.keySet()) {
				str+="<tr>";
				str+="<th>"+e+"</th>";
				str+="<th>"+listOfAlerts.get(e)+"</th>";
				str+="<th>"+((listOfAlerts.get(e))*100/retrieveAlerts()+"%")+"</th>";
			}

		}
		
		if(!listOfMF.isEmpty()) {
		str+="<br><br>\n";
		str+="<table class='distinguishedMalfunctionTable'><tr><th>Malfunctions: "+displaMFs()+"</th></tr></table>\n";
		str+="<table class='distinguishedMalfunctionTable'><tr>\n";
		str+="<td>Object Type</td><td>Number of Malfunctions</td><td>Malfucntions rate</td>\n";
		str+="</tr>\n";
		
			for (String e : listOfMF.keySet()) {
				str+="<tr>";
				str+="<th>"+e+"</th>";
				str+="<th>"+listOfMF.get(e)+"</th>";
				str+="<th>"+((listOfMF.get(e))*100/retrieveMalfunctions()+"%")+"</th>";
				
		}
	}
	return str;
	}
}
