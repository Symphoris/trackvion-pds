package business;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.Profil;
import beans.Questionnary;
import common.Configuration;

public class QuestionnayForm {
	private Questionnary questionnaire;
	private Profil profil;
	
	public QuestionnayForm(Questionnary questionnaire) {
		this.questionnaire = questionnaire;
		
	}
	
	public boolean executeQuestionnary() {
		Connection connection = Configuration.connectionPool.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into Questionnary(ID_Candidate,health,sporty,allergic,disabled,financeOption) VALUES (?,?,?,?,?,?);");
			
			
			
			stmt.setInt(1, questionnaire.getIdCandidate());
			stmt.setString(2, questionnaire.getHealth());
			stmt.setString(3, questionnaire.getSporty());
			stmt.setString(4, questionnaire.getAllergic());
			stmt.setString(5, questionnaire.getDisabled());
			stmt.setString(6, questionnaire.getFinanceOption());
			stmt.executeUpdate();
			Configuration.connectionPool.closeConnection(connection);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Configuration.connectionPool.closeConnection(connection);	
			return false;
		}
		return true;
	}
	
		
}
