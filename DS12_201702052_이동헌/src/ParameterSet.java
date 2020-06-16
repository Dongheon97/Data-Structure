
public class ParameterSet {

	//private instance variables
	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;
	
	//Getter / Setter
	public int startingSize() {
		return this._startingSize;
	}
	public void setStartingSize(int newStartingSize) {
		this._startingSize = newStartingSize;
	}
	
	public int numberOfSizeIncreasingSteps() {
		return this._numberOfSizeIncreasingSteps;
	}
	public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps) {
		this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps;
	}
	
	public int incrementSize() {
		return this._incrementSize;
	}
	public void setIncrementSize(int newIncrementSize) {
		this._incrementSize = newIncrementSize;
	}
	
	//Constructor
	public ParameterSet(int givenStartingSize, 
			int givenNumberOfSizeIncreasingSteps, int givenIncrementSize) {
		this.setStartingSize(givenStartingSize);
		this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
		this.setIncrementSize(givenIncrementSize);
	}
	
	//public method
	public int maxDataSize() {
		return (this.startingSize() 
				+ ( this.numberOfSizeIncreasingSteps()*( this.incrementSize()-1 ) ));
	}
}
