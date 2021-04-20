package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.Configuration;

public class UseHobsInsert {
	
	public int ourUpdate;
	public int id;
		
		public UseHobsInsert(int ourUpdate, int id) {
			this.ourUpdate=ourUpdate;
			this.id = id;
		}
		
		
		public boolean executeInscription() {
			Connection connection = Configuration.connectionPool.getConnection();
			int idOC ;
			try {
				System.out.println(id);
				
				PreparedStatement stmt2 = connection.prepareStatement("UPDATE Objects SET State_Object = ? WHERE ID_Apartment = ? AND Type_Object ='Hob';");
				stmt2.setInt(1,ourUpdate);
				stmt2.setInt(2,id);
				
				stmt2.executeUpdate();
				
				
			
				
				Configuration.connectionPool.closeConnection(connection);	
			} catch (Exception e) {
				System.out.println(e.getMessage());
				Configuration.connectionPool.closeConnection(connection);	
				return false;
			}
			return true;
		}

}
