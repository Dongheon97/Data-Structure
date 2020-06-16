
public class Timer {

	//private instance variables
	private long _startTime;
	private long _stopTime;
	
	//Getter / Setter
	private long startTime() {
		return this._startTime;
	}
	private void setStartTime(long newStartTime) {
		this._startTime = newStartTime;
	}
	
	private long stopTime() {
		return this._stopTime;
	}
	private void setStopTime(long newStopTime) {
		this._stopTime = newStopTime;
	}
	
	//Constructor 
	public Timer() {
		this.setStartTime(0);
		this.setStopTime(0);
	}
	
	//public Methods
	public void start() {
		this.setStartTime(System.nanoTime());
	}
	public void stop() {
		this.setStopTime(System.nanoTime());
	}
	
	public long duration() {
		return (this.stopTime()-this.startTime());
	}
}
