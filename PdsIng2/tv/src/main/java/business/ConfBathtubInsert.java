package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Alert;
import beans.ConnectedBathtub;
import common.Configuration;

public class ConfBathtubInsert {
	
public int maxWater;
public int id;
	
	public ConfBathtubInsert(int maxWater, int id) {
		this.maxWater=maxWater;
		this.id = id;
	}
	
	
	public boolean executeInscription() {
		Connection connection = Configuration.connectionPool.getConnection();
		int idOC ;
		try {
			System.out.println(id);
			
			PreparedStatement stmt2 = connection.prepareStatement("SELECT ID_Object FROM Objects WHERE ID_Apartment = ? AND Type_Object ='Bathtub';");
			stmt2.setInt(1,id);
			ResultSet result = stmt2.executeQuery();
			
			
			while(result.next()) {
				
				
				
				idOC = ((Number) result.getObject(1)).intValue();
				System.out.println("IDOC"+idOC);
				
				PreparedStatement stmt = connection.prepareStatement("UPDATE ConnectedBathtub_Objects SET MaxWaterLevel = ? Where ID_ConnectedBathtub = ? ;");
				System.out.println(maxWater);
				stmt.setInt(1, maxWater);
				stmt.setInt(2, idOC);
				
				 stmt.executeUpdate();
				
			}
			
			
			Configuration.connectionPool.closeConnection(connection);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Configuration.connectionPool.closeConnection(connection);	
			return false;
		}
		return true;
	}

}
