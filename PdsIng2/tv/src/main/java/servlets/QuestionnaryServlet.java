package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import beans.Candidate;
import beans.Questionnary;
import business.ProfilService;
import business.QuestionnayForm;
import common.Configuration;

public class QuestionnaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String finance;
   
    public QuestionnaryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/questionnary.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = Configuration.connectionPool.getConnection();
		Questionnary questionnaire = new Questionnary();
		Candidate candidate = new Candidate();
		
		HttpSession session = request.getSession();
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String)session.getAttribute("lastname");
		String	a = (String)session.getAttribute("age");
		int age = Integer.parseInt(a);
		
		//System.out.println(session.getAttribute("firstname"));
		candidate.setFirstname(firstname);
		candidate.setLastname(lastname);
		candidate.setAge(age);
		ProfilService profilservice = new ProfilService(questionnaire,candidate);
		
		
		if(request.getParameter("isdisease").equals("yes")) {
			questionnaire.setHealth(request.getParameter("diseasename"));
		}else {
			questionnaire.setHealth(" ");
		}
		
		if(request.getParameter("athlete").equals("yes")) {
			questionnaire.setSporty(request.getParameter("frequence"));
		} else {
			questionnaire.setSporty("");
		}
		if(request.getParameter("allergie").equals("yes")) {
			questionnaire.setAllergic(request.getParameter("allergiename"));
		} else {
			questionnaire.setAllergic(" ");
		}
		
		if(request.getParameter("disabled").equals("yes")) {
			String disabled ="";
			String[] res = request.getParameterValues("whichdisabled" );
			for (int i = 0; i < res.length; ++i){
				questionnaire.getList().add(res[i]);
				 System.out.println(disabled);
				
				}
			questionnaire.setDisabled(disabled);
			
		} else {
			questionnaire.setDisabled(" ");
		}
		
		if(request.getParameter("finance").equals("alone")){
			questionnaire.setFinanceOption(request.getParameter("summax"));
		} else if(request.getParameter("finance").equals("pension")) {
			questionnaire.setFinanceOption(request.getParameter("agency"));
		} else if (request.getParameter("finance").equals("social")) {
			questionnaire.setFinanceOption("social");
		}
		finance = request.getParameter("finance");
		questionnaire.setFinancialState(finance);
		System.out.println(finance);
		//questionnaire.setIdCandidate(2);
		
		 try {
			PreparedStatement state = connection.prepareStatement("Select ID_Candidate FROM Candidate WHERE firstname = ?");
				state.setString(1, firstname);
				
				ResultSet result = state.executeQuery();
				result.first();
				int id = result.getInt("ID_Candidate");
				questionnaire.setIdCandidate(id);
			} catch (SQLException e) {
				
				System.err.println(e.getMessage());
				
			}
		QuestionnayForm questionnaryForm = new QuestionnayForm(questionnaire);
		
		 if(questionnaryForm.executeQuestionnary()) {
			
			 profilservice.questionnarytreatment();
			 //response.sendRedirect("/tv/package");
		    	request.setAttribute("optionalMessage", "succesfull!");
		 }	
		    else 
		    	request.setAttribute("optionalMessage", "A problem occured during the process :("); 
    
		}

	public String getFinance() {
		return finance;
	}
}
