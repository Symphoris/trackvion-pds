package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import beans.ApartmentOC;
import common.Configuration;

public class MapAppatments {
	
	private HashMap<Integer,ArrayList<ApartmentOC>> map;
	private Integer locatedApartId = -1;

	public MapAppatments() throws IOException {
		map = new HashMap<Integer, ArrayList<ApartmentOC>>();
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery
					("SELECT ID_Apartment, Name_Apartment, ID_Level FROM Apartments" );
							
							
			Integer level;
			while(result.next()) {
				level = result.getInt(3);
				if(!map.containsKey(level))
					map.put(level, new ArrayList<ApartmentOC>());
				map.get(level).add(new ApartmentOC(result));
			}
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while constructing the map : " + e.getMessage()); 
		}
	}

	public MapAppatments(HashMap<Integer, ArrayList<ApartmentOC>> map) {
		this.map = map;
	}

	public MapAppatments(Integer locatedApartId) throws IOException {
		this();
		this.locatedApartId = locatedApartId;
	}

	public String toString() {
		String result = "";
		final Integer maxnumberLine = 5;
		for (Integer level : map.keySet()) {
			result+="<div class='level'>" + "\n";
			result+="<h4>Level " + level + "</h4>" + "\n";
			result+="<div>" + "\n";
			Integer numberLine = 0;
			for(ApartmentOC apart : map.get(level)) {
				result+= apart.getLink(locatedApartId);
				if(++numberLine==maxnumberLine) {
					result+="</div>\n<div>\n";
					numberLine=0;
				}
			}
			result+="</div>" + "\n";
			result+="</div>" + "\n";
		}
		return result;
	}


}
