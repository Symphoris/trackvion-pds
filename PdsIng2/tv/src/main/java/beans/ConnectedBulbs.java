package beans;

public class ConnectedBulbs {

	private int id_ConnectedBulbs ;
	private int brightness;
	private int actualBrightness;
	private int brightnessMax ;
	private int operatingTime;
	
	private int operatingTimeMax ;
	private boolean status ;
	public int getId_ConnectedBulbs() {
		return id_ConnectedBulbs;
	}
	public void setId_ConnectedBulbs(int id_ConnectedBulbs) {
		this.id_ConnectedBulbs = id_ConnectedBulbs;
	}
	public int getBrightness() {
		return brightness;
	}
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	public int getActualBrightness() {
		return actualBrightness;
	}
	public void setActualBrightness(int actualBrightness) {
		this.actualBrightness = actualBrightness;
	}
	public int getBrightnessMax() {
		return brightnessMax;
	}
	public void setBrightnessMax(int brightnessMax) {
		this.brightnessMax = brightnessMax;
	}
	public int getOperatingTime() {
		return operatingTime;
	}
	public void setOperatingTime(int operatingTime) {
		this.operatingTime = operatingTime;
	}
	public int getOperatingTimeMax() {
		return operatingTimeMax;
	}
	public void setOperatingTimeMax(int operatingTimeMax) {
		this.operatingTimeMax = operatingTimeMax;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
