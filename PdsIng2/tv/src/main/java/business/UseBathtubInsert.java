package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.Configuration;

public class UseBathtubInsert {
	public int ourupdate;
	public int id;
		
		public UseBathtubInsert(int ourupdate, int id) {
			this.ourupdate=ourupdate;
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
					
					PreparedStatement stmt = connection.prepareStatement("UPDATE ConnectedBathtub_Objects SET TargetWaterLevel = ? Where ID_ConnectedBathtub = ? ;");
					System.out.println(ourupdate);
					stmt.setInt(1, ourupdate);
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
