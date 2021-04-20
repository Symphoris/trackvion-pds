package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricalMedicalData {

	private Integer id;
	private String date;
	private Float data;
	private Integer object;

	
	public HistoricalMedicalData(ResultSet result) throws SQLException {
		id = result.getInt(1);
		date = result.getString(2);
		data = result.getFloat(3);
		object = result.getInt(4);
		
	}


	public Integer getId() {
		return id;
	}


	public String getDate() {
		return date;
	}


	public Float getData() {
		return data;
	}


	public Integer getObject() {
		return object;
	}


	@Override
	public String toString() {
		return  data +","+ date;
	}


	
	
	
	
}
