package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.Position;
import common.Configuration;

public class TrackResident {

	private Position position;

	public TrackResident() {
	}

	public void  positionDetails() throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM POSITIONS ORDER BY ID_Position DESC LIMIT ? ;");
			stmt.setInt(1, 10);
			ResultSet result = stmt.executeQuery();
			if(!result.next())
				throw new Exception("No Data In the table");
			position = new Position(result);
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while retrieving the data  : " + e.getMessage());
		}
	}

	public String getData(int positions) {

		String value = "";
		try {
			switch(positions) {
			case 1:
				positionDetails();
				value+="<div id='positionX'>" + position.getPositionX() + "</div>";
				break;
			case 2:
				positionDetails();
				value+="<div id='positionY'>" + position.getPositionY() + "</div>";
				break;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}



}