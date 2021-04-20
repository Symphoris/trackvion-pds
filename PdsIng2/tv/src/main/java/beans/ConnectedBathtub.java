package beans;

public class ConnectedBathtub {
	
	private int id_ConnectedBathtub ;
	private int actualWaterLevel ;
	public static int maxWaterlevel ;
	private static int waterLevel;
	private int waterTemperature;
	private boolean status;
	public int getId_ConnectedBathtub() {
		return id_ConnectedBathtub;
	}
	public void setId_ConnectedBathtub(int id_ConnectedBathtub) {
		this.id_ConnectedBathtub = id_ConnectedBathtub;
	}
	public int getActualWaterLevel() {
		return actualWaterLevel;
	}
	
	public void setActualWaterLevel(int actualWaterLevel) {
		this.actualWaterLevel = actualWaterLevel;
	}
	public int getMaxWaterlevel() {
		return maxWaterlevel;
	}
	public void setMaxWaterlevel(int maxWaterlevel) {
		ConnectedBathtub.maxWaterlevel = maxWaterlevel;
	}
	public int getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(int waterLevel) {
		ConnectedBathtub.waterLevel = waterLevel;
	}
	public int getWaterTemperature() {
		return waterTemperature;
	}
	public void setWaterTemperature(int waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
