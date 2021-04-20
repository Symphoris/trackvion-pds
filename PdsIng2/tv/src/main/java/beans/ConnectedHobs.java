package beans;

public class ConnectedHobs {
	
	private int id_ConnectedHobs;
	private int actualTemperature;
	private int MaxTimeActivity;
	private boolean status ;
	
	
	public int getMaxTimeActivity() {
		return MaxTimeActivity;
	}
	public void setMaxTimeActivity(int maxTimeActivity) {
		MaxTimeActivity = maxTimeActivity;
	}
	public int getId_ConnectedHobs() {
		return id_ConnectedHobs;
	}
	public void setId_ConnectedHobs(int id_ConnectedHobs) {
		this.id_ConnectedHobs = id_ConnectedHobs;
	}
	public int getActualTemperature() {
		return actualTemperature;
	}
	public void setActualTemperature(int actualTemperature) {
		this.actualTemperature = actualTemperature;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
