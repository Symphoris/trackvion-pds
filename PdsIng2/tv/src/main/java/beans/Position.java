package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position {

	private Integer id;
	private String date;
	private float positionX;
	private float positionY;
	
	public Position(ResultSet result) throws SQLException {
		id = result.getInt(1);
		date = result.getString(2);
		positionX = result.getFloat(3);
		positionY = result.getFloat(4);

	}
	
	public Integer getId() {
		return id;
	}
	public String getDate(){
		return date;
	}
	public float getPositionX() {
		return positionX;
	}
	public float getPositionY() {
		return positionY;
	}

	


}
	

