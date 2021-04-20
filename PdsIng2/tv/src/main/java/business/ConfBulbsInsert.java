package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.ConnectedBulbs;
import common.Configuration;

public class ConfBulbsInsert {
	
	public int ourUpdate;
	public int id;
		
		public ConfBulbsInsert(int ourUpdate, int id) {
			this.ourUpdate=ourUpdate;
			this.id = id;
		}
		
		
		public boolean executeInscription() {
			Connection connection = Configuration.connectionPool.getConnection();
			int idOC ;
			try {
				System.out.println(id);
				
				PreparedStatement stmt2 = connection.prepareStatement("SELECT ID_Object FROM Objects WHERE ID_Apartment = ? AND Type_Object ='Bulb';");
				stmt2.setInt(1,id);
				ResultSet result = stmt2.executeQuery();
				
				
				while(result.next()) {
					
					
					idOC = ((Number) result.getObject(1)).intValue();
					System.out.println("IDOC"+idOC);
					
					PreparedStatement stmt = connection.prepareStatement("UPDATE ConnectedBulbs_Objects SET MaxBulbOperatingTime = ? Where ID_ConnectedBulbs = ? ;");
					System.out.println(ourUpdate);
					stmt.setInt(1, ourUpdate);
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
