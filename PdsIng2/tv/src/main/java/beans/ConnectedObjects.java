package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectedObjects {
	private Integer id;
	private String type;
	private Boolean state;
	private Integer apartmentId;
	private String macAddress;
	private String nickname;
	private Integer watchMinutesOn;
	private Integer watchMinutesOff;
	
	public ConnectedObjects (ResultSet result) throws SQLException{
		id = result.getInt(1);
		type = result.getString(2);
		state = result.getBoolean(3);
		apartmentId = result.getInt(4);
		macAddress = result.getString(5);
		nickname = result.getString(6);
		watchMinutesOn=result.getInt(7);
		watchMinutesOff=result.getInt(8);
	}
	
	public ConnectedObjects (Integer id) throws SQLException{
		this.id=id;
	}

	public int getApartmentId () {
		return apartmentId;
	}
	
	public String getLink(Integer locatedOCId) {
		String classLocated = "";
		if(id==locatedOCId)
			classLocated = "blink"; // If this is the apart asked to be located, we add the blink css effect.
			return "<a class='apartment noalert " + classLocated + "'href='configAndUse/" + id + "'>" + type + "</a>\n";
	}

	
	
}
