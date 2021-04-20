package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Candidate implements Comparable{
	private Questionnary questionnaire = new Questionnary();
	private String civility;
	private int age;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int id = questionnaire.getIdCandidate();
	private String profil;
	private int noteFinance;
	private int noteSante;
	private float noteGlobale = 0;
	
	
	
	
	public Candidate(ResultSet result) throws SQLException {
		super();
		this.id = result.getInt(1);
		this.civility = result.getString(2);
		this.age = result.getInt(3);
		this.firstname = result.getString(4);
		this.lastname = result.getString(5);
		this.email = result.getString(6);
		this.profil = result.getString(7);
		this.noteFinance = result.getInt(9);
		this.noteSante = result.getInt(10);
		calculNoteGlobale(50, 50);
	}
	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCivility() {
		return civility;
	}
	public void setCivility(String civility) {
		this.civility = civility;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCandidateTableLine() {
		String action = "<form action='/tv/candidatelist' method='post'><input type='hidden' name='id' value='"+id+"'>" +
				"<div class='row'><input type='submit' value='Delete'></div></form>";
		
		return "<tr>"
				+ "<td>" + id + "</td>"
				+ "<td>" + civility + "</td>"
				+ "<td>" + age + "</td>"
				+ "<td>" + firstname + "</td>"
				+ "<td>" + lastname + "</td>"
				+ "<td>" + email + "</td>"
				+ "<td>" + profil + "</td>"
				+ "<td>" + noteFinance + "</td>"
				+ "<td>" + noteSante + "</td>"
				+ "<td>" + noteGlobale + "</td>"
				+ "<td>" + action + "</td>"
			+ "</tr>";
	}
	public Questionnary getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnary questionnaire) {
		this.questionnaire = questionnaire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public int getNoteFinance() {
		return noteFinance;
	}
	public void setNoteFinance(int noteFinance) {
		this.noteFinance = noteFinance;
	}
	public int getNoteSante() {
		return noteSante;
	}
	public void setNoteSante(int noteSante) {
		this.noteSante = noteSante;
	}
	public float calculNoteGlobale( int ponderationSante, int ponderationFinance) {
		
		noteGlobale= ((float)noteSante*(float)ponderationSante/100) + ((float)noteFinance*(float)ponderationFinance/100);
		
		
		return noteGlobale;
		
	}
	public float getNoteGlobale() {
		return noteGlobale;
	}
	public void setNoteGlobale(float noteGlobale) {
		this.noteGlobale = noteGlobale;
	}

	public int compareTo(Object o) {
		Candidate c = (Candidate) o;
		if(this.getNoteGlobale()> c.getNoteGlobale()) {
			return -1;
		}
		else if (this.getNoteGlobale()<c.getNoteGlobale()) {
			return 1;
		}
		else {
			return 0;

		}
	}
	

}
