package beans;

import java.util.ArrayList;

public class Questionnary {
	private int idCandidate;
	private String health;
	private String sporty;
	private String allergic;
	private String financeOption;
	private String disabled;
	private String financialState;
	private ArrayList<String> list = new ArrayList<String>();
	
	public Questionnary() {
		
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getSporty() {
		return sporty;
	}
	public void setSporty(String sporty) {
		this.sporty = sporty;
	}
	public String getAllergic() {
		return allergic;
	}
	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
	public String getFinanceOption() {
		return financeOption;
	}
	public void setFinanceOption(String financeOption) {
		this.financeOption = financeOption;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public String getFinancialState() {
		return financialState;
	}
	public void setFinancialState(String financialState) {
		this.financialState = financialState;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	


	
}
