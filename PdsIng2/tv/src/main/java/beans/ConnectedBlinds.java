package beans;

public class ConnectedBlinds {
	
	private int id_ConnectedBlinds;
	private int openingTimeMax ;
	private int openingTime ;
	private boolean status ;
	public int getId_ConnectedBlinds() {
		return id_ConnectedBlinds;
	}
	public void setId_ConnectedBlinds(int id_ConnectedBlinds) {
		this.id_ConnectedBlinds = id_ConnectedBlinds;
	}
	public int getOpeningTimeMax() {
		return openingTimeMax;
	}
	public void setOpeningTimeMax(int openingTimeMax) {
		this.openingTimeMax = openingTimeMax;
	}
	
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
