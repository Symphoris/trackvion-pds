package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentOC {
	
	private Integer id;
	private String name;
	private Integer level;
	
	
	public ApartmentOC(ResultSet result) throws SQLException {
		id=result.getInt(1);
		name=result.getString(2);
		level=result.getInt(3);
		
	}
	
	public ApartmentOC(Integer id, String name, Integer level) {
		this.id=id;
		this.name=name;
		this.level=level;
	}

	public String getLink(Integer locatedApartId) {
		String classLocated = "";
		if(id==locatedApartId)
			classLocated = "blink"; 
			return "<a class='apartment noalert " + classLocated + "'href='apartmentOC/" + id + "'>" + name + "</a>\n";
	}

	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getLevel() {
		return level;
	}
}

