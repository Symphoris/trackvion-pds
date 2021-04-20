
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Resident extends User {

	private Integer id;
	private String login;
	private String lastName;
	private String firstName;
	private Integer age;
	private String information;
	private Integer apartment;

	public Resident(ResultSet result) throws SQLException {
		id = result.getInt(1);
		login = result.getString(2);
		lastName = result.getString(4);
		firstName = result.getString(5);
		age = result.getInt(6);
		information = result.getString(7);
		apartment = result.getInt(8);
	}
	
	

	public String getLastName() {
		return lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public String toString() {
		return firstName + " " + lastName + " (" + age + " years old) : " + information;
	}
	

	public String getResidentList() {
		
		return "<tr><td>" + id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + login + 
				"</td><td>" + "</td></tr>";
	}



	public Integer getAge() {
		return age;
	}

	public String getInformation() {
		return information;
	}
	
	public Integer getApartment() {
		return apartment;
	}
	


}
