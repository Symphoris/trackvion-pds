package beans;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalAlerts {
	private Integer id;
	private Boolean stateAlerts;
	private Boolean stateNotification;
	private Integer level;
	private String date;
	private String message;
	private Integer objectId;
	
	public MedicalAlerts(ResultSet result) throws SQLException {
		id = result.getInt(1);
		stateAlerts = result.getBoolean(2);
		stateNotification = result.getBoolean(3);
		level = result.getInt(4);
		date = result.getString(5);
		message = result.getString(6);
		objectId = result.getInt(7);
	
		
	}
	
	public MedicalAlerts(Integer id, String date, String message, Integer objectId) {
		super();
		this.id = id;
		this.date = date;
		this.message = message;
		this.objectId = objectId;
	}



	public MedicalAlerts(int id) {
		this.id=id;
	}
	


	public Integer getId() {
		return id;
	}


	public Boolean getStateAlerts() {
		return stateAlerts;
	}


	public Boolean getStateNotification() {
		return stateNotification;
	}


	public Integer getLevel() {
		return level;
	}


	public String getDate() {
		return date;
	}


	public String getMessage() {
		return message;
	}


	public Integer getObjectId() {
		return objectId;
	}
	
}
