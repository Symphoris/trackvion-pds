package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import beans.Candidate;
import beans.Employee;
import common.Configuration;

public class CandidateList {

	private ArrayList<Candidate> candidates;
	
	public CandidateList() throws IOException {
		candidates = new ArrayList<Candidate>();
		Connection connection = Configuration.connectionPool.getConnection(); 
		String requestSQL = "SELECT * FROM Candidate";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			while(result.next()) {
				candidates.add(new Candidate(result));
			}
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while getting the candidate list : " + e.getMessage());
		}
	}
	public boolean deleteCandidate(String id) {
		
		Connection connection = Configuration.connectionPool.getConnection();
		
	    try {
	    	PreparedStatement stmt = connection.prepareStatement("DELETE FROM Candidate WHERE ID_Candidate=?;");
	    	stmt.setString(1, id);
			stmt.executeUpdate();
			Configuration.connectionPool.closeConnection(connection);
		} catch (Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			return false;
		}
	    
	    Integer intId = Integer.parseInt(id);
	    // We still have to delete the employee from the list
	    for(Candidate candidate : candidates)
	    	if(candidate.getId()==intId) {
	    		candidates.remove(candidate);
	    		return true;
	    	}
	    return false;
	}
	public int noteMax() throws IOException {
		int noteMax = 0;
		Connection connection = Configuration.connectionPool.getConnection(); 
		String requestSQL = "SELECT MAX(noteFinance) FROM Candidate";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			result.next();
			noteMax = result.getInt(1);
			
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while getting the noteMax : " + e.getMessage());
		}
		return noteMax;
	}
	
	public int noteMaxSante() throws IOException {
		int noteMax = 0;
		Connection connection = Configuration.connectionPool.getConnection(); 
		String requestSQL = "SELECT MAX(noteSante) FROM Candidate";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(requestSQL);
			result.next();
			noteMax = result.getInt(1);
			
			Configuration.connectionPool.closeConnection(connection);
		}
		catch(Exception e) {
			Configuration.connectionPool.closeConnection(connection);
			throw new IOException("An error occured while getting the noteMaxSante : " + e.getMessage());
		}
		return noteMax;
	}
	
	
	
	
	
	public String getCandidateTableLines() {
		CandidateComparator candidateComparator = new CandidateComparator();
		Collections.sort(candidates, candidateComparator);

		String tableLines = "";
		for(Candidate candidate : candidates)
			tableLines+= candidate.getCandidateTableLine() + "\n";
		return tableLines;
	}
	
	public String getCandidateBYFinanceTableLines() {
		ArrayList<Candidate> candidatesMaxFinance = new ArrayList<Candidate>() ;
		
		try {
			int max = this.noteMax();
			for(Candidate candidate : candidates) {
				if(candidate.getNoteFinance()==max) {
					candidatesMaxFinance.add(candidate);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String tableLines = "";
		for(Candidate candidate : candidatesMaxFinance)
			tableLines+= candidate.getCandidateTableLine() + "\n";
		return tableLines;
	}
	
	public String getCandidateBYSanteTableLines() {
		ArrayList<Candidate> candidatesMaxSante = new ArrayList<Candidate>() ;
		
		try {
			int max = this.noteMaxSante();
			for(Candidate candidate : candidates) {
				if(candidate.getNoteSante()==max) {
					candidatesMaxSante.add(candidate);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String tableLines = "";
		for(Candidate candidate : candidatesMaxSante)
			tableLines+= candidate.getCandidateTableLine() + "\n";
		return tableLines;
	}
	public String updatadeNoteGlobale(int ponderationSante, int ponderationFinance) {
		CandidateComparator candidateComparator = new CandidateComparator();
	
			
			for(Candidate candidate : candidates) {
				candidate.calculNoteGlobale(ponderationSante, ponderationFinance);
			}
		
			Collections.sort(candidates, candidateComparator);
		
			String tableLines = "";
			for(Candidate candidate : candidates)
				tableLines+= candidate.getCandidateTableLine() + "\n";
			return tableLines;
	}
	

}
