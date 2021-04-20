package business;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.Candidate;
import beans.Profil;
import beans.Questionnary;
import common.Configuration;
import servlets.QuestionnaryServlet;

public class ProfilService {
	private Questionnary questionnary;
	private Profil profil = new Profil();
	private Candidate candidate;
	private int candidatNoteFinance = 0;
	private int noteSante=0;
	private String disabled;
	private String etatSante;
	
	QuestionnaryServlet q = new QuestionnaryServlet();
	

	public ProfilService(Questionnary questionnary, Candidate candidate ) {
		this.questionnary = questionnary;
		this.candidate = candidate;
		this.profil = profil;

	}
	
	public void questionnarytreatment() {
		String financialState = questionnary.getFinancialState();
		  etatSante = questionnary.getHealth();
		 String sporty = questionnary.getSporty();
		 disabled = questionnary.getDisabled();
		 String financialOption = questionnary.getFinanceOption();
		 String allergie = questionnary.getAllergic();
		 String firstname = candidate.getFirstname();
		 String lastname = candidate.getLastname(); 
		 int age = candidate.getAge();
		 profil.setAge(age);
		 profil.setFirstname(firstname);
		 profil.setLastname(lastname);
		
		 
		 if (!questionnary.getList().isEmpty()
				 && (etatSante.equals("hypertension") || etatSante.equals("diabetes"))){
			 profil.setProfilType("Malade non Aautonome");
			 String p = profil.getProfilType(); 
		 }else if((etatSante.equals("hypertension") || etatSante.equals("diabetes")) && 
				 (questionnary.getList().isEmpty())) {
			 profil.setProfilType("Malade Autonome");
			 			 
		 }
		 
		 else if ((etatSante.equals(" ") || etatSante.equals(" ")) &&  (!questionnary.getList().isEmpty())) {
			 profil.setProfilType("Non Malade et Non Autonome");
			 
		 } 
		 else {
			 profil.setProfilType("Nom Malade et Autonome");
		 }
		 
		 if(financialState.equals("pension") && profil.getProfilType().equals("Malade_non _Aautonome")) {
			 candidatNoteFinance += 9;
		 }
		 
		 Connection connection = Configuration.connectionPool.getConnection();
		 candidatFinanceNote();
		 NoteSante();
			try {
				PreparedStatement stmt = connection.prepareStatement("update Candidate set profil =?, noteFinance =?, noteSante =? where ID_Candidate = ?; ");
				
				stmt.setString(1, profil.getProfilType());
				stmt.setInt(2, candidatNoteFinance);
				stmt.setInt(3, noteSante);
				stmt.setInt(4, questionnary.getIdCandidate());
				stmt.executeUpdate();
				Configuration.connectionPool.closeConnection(connection);	
			} catch (Exception e) {
				System.out.println(e.getMessage());
				Configuration.connectionPool.closeConnection(connection);				
			}	
	}	
	public void candidatFinanceNote () {
			
		String financialState = questionnary.getFinancialState();
		if(financialState.equals("pension")){
				candidatNoteFinance +=8;
		
		}
		else if(financialState.equals("alone")) {
			String s = questionnary.getFinanceOption();
			int sum = Integer.parseInt(s);
			if(sum >3000  &&sum<4000)
				candidatNoteFinance +=8;
			if(sum>4500)
				candidatNoteFinance +=9;
			if(sum>4000 && sum <4500)
				candidatNoteFinance+=9;
			if(sum>2000 && sum<3000)
				 candidatNoteFinance +=6;
			if(sum>1500 && sum<2000)
				 candidatNoteFinance +=4;
			 
		}
		else if(financialState.equals("social"))
			candidatNoteFinance +=6;
		
		
	}
	public void NoteSante() {
		 etatSante = questionnary.getHealth();
		 disabled = questionnary.getDisabled();
		if (!questionnary.getList().isEmpty()
				 && (etatSante.equals("hypertension") || etatSante.equals("diabetes")))
			noteSante +=9;
		if((etatSante.equals("hypertension") || etatSante.equals("diabetes")) && 
				 (questionnary.getList().isEmpty()))
			noteSante+=7;
		if((etatSante.equals(" ") || etatSante.equals(" ")) &&  (!questionnary.getList().isEmpty()))
			noteSante +=8;
		if((etatSante.equals(" ") || etatSante.equals(" ")) &&  (questionnary.getList().isEmpty()))
			noteSante +=4;
				
	}
	 

}
