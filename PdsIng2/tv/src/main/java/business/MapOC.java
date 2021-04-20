package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import beans.Alert;
import beans.Apartment;
import beans.ApartmentOC;
import beans.ConnectedObject;
import beans.ConnectedObjects;
import beans.Malfunction;
import beans.Resident;
import common.Configuration;

public class MapOC {
	
	private HashMap<Integer,ArrayList<ConnectedObjects>> map;
	private Integer locatedAppartmentId = -1;


	private ApartmentOC apartment;



	public MapOC() throws IOException{
		
	}

	public MapOC(HashMap<Integer, ArrayList<ConnectedObjects>> map) {
		this.map = map;
	}

	public MapOC(Integer idt) throws IOException {
		
		this.locatedAppartmentId = idt;
		
		map = new HashMap<Integer, ArrayList<ConnectedObjects>>();
		Connection connection = Configuration.connectionPool.getConnection();
		System.out.println(locatedAppartmentId);
		try {
	
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Objects WHERE ID_Apartment=?;");
			System.out.println(locatedAppartmentId);
			stmt.setInt(1, locatedAppartmentId);
			ResultSet result = stmt.executeQuery();
			Integer id;
			while(result.next()) {
				id = result.getInt(1);
				if(!map.containsKey(id))
					map.put(id, new ArrayList<ConnectedObjects>());
				map.get(id).add(new ConnectedObjects(result));
			}
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the apartment objects : " + e.getMessage());
		}
		
	}


	

	public ApartmentOC getApartment() {
		return apartment;
	}



	public String toString() {
		String result = "";
		final Integer maxnumberLine = 5;
		for (Integer id : map.keySet()) {
			result+="<div class='level'>" + "\n";
			Integer numberLine = 0;
			for(ConnectedObjects obj : map.get(id)) {
				result+= obj.getLink(id);
				if(++numberLine==maxnumberLine) { 
					result+="</div>\n<div>\n";
					numberLine=0;
				}
			}
			result+="</div>" + "\n";
			
		}
		return result;
	}	

}



