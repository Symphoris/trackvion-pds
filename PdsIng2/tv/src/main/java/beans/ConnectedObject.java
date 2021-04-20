package beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Configuration;

public class ConnectedObject {

	private Integer id;
	private String type;
	private Boolean state;
	private Integer apartmentId;
	private String macAddress;
	private String nickname;
	private Integer watchMinutesOn;
	private Integer watchMinutesOff;

	public ConnectedObject (ResultSet result) throws SQLException{
		id = result.getInt(1);
		type = result.getString(2);
		state = result.getBoolean(3);
		apartmentId = result.getInt(4);
		macAddress = result.getString(5);
		nickname = result.getString(6);
		watchMinutesOn=result.getInt(7);
		watchMinutesOff=result.getInt(8);
	}

	public ConnectedObject (Integer id) throws SQLException{
		this.id=id;
	}

	public int getApartmentId () {
		return apartmentId;
	}
	
	
	public String getTableLine() {
		String line = "<tr>\n";
		line+="<td>" + id + "</td>";
		line+="<td>" + type + "</td>";
		line+="<td>" + ( (state)? "On":"Off") + "</td>";

		// We add a link to change the nickname
		line+="<td><form action='' method='post'><input type='hidden' name='objectNickId' value='"+id+"'>" +
				"<div class='row'><input type='text' name='nickname' value='" + nickname +"'></div></form></td>";

		line+="<td>" + macAddress + "</td>";

		//We add the configuration popup
		line+="<td><a href='#popup" + id + "'>Edit</a></td>";
		line+="<div id='popup" + id + "' class='overlay'><div class='popup'>"
				+ "<h2>Configuration of " + (nickname.isEmpty()? type : nickname) + " (" + id + ")</h2>" 
				+ "<a class='close' href='#'>&times;</a><div class='content'>" 
				+ "<form action='#' method='post'><input type='hidden' name='objectWatchId' value='"+id+"'>"
				+ "<div class='row'><label for='watchMinutesOn'>Maximum inactivity duration  if ON (in minutes) </label><input type='text' style='width:10%' name='watchMinutesOn' value='" + watchMinutesOn +"'></div>"
				+ "<div class='row'><label for='watchMinutesOff'>Maximum inactivity duration if OFF (in minutes)</label><input type='text' style='width:10%' name='watchMinutesOff' value='" + watchMinutesOff +"'></div>"
				+ "<div class='row'><input type='submit' value='Save'</div>"
				+ "</form></div></div></div>";

		line+= "</tr>\n";
		return line;
	}

	public void updateNickNameDB(String newNickname) throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			// We retrieve the apartment
			PreparedStatement stmt = connection.prepareStatement("UPDATE Objects SET Nickname_Object=? WHERE ID_Object=?;");
			stmt.setString(1, newNickname);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			this.state=false;
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while updating the state of the alert : " + e.getMessage());
		}
	}

	public void updateWatchMinutesDB(Integer watchMinutesOn, Integer watchMinutesOff) throws IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			// We retrieve the apartment
			PreparedStatement stmt = connection.prepareStatement("UPDATE Objects SET watchMinutesOn=?,watchMinutesOff=? WHERE ID_Object=?;");
			stmt.setInt(1, watchMinutesOn);
			stmt.setInt(2, watchMinutesOff);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			this.state=false;
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while updating the state of the alert : " + e.getMessage());
		}
	}

}
