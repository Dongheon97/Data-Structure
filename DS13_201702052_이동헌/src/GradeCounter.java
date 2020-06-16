
public class GradeCounter {

	//비공개 인스턴스 변수
	private int _numberofA;
	private int _numberofB;
	private int _numberofC;
	private int _numberofD;
	private int _numberofF;
	
	//Getter / Setter
	public int numberOfA() {
		return this._numberofA;
	}
	public void setNumberOfA(int newNumberOfA) {
		this._numberofA = newNumberOfA;
	}
	public int numberOfB() {
		return this._numberofB;
	}
	public void setNumberOfB(int newNumberOfB) {
		this._numberofB = newNumberOfB;
	}
	public int numberOfC() {
		return this._numberofC;
	}
	public void setNumberOfC(int newNumberOfC) {
		this._numberofC = newNumberOfC;
	}
	public int numberOfD() {
		return this._numberofD;
	}
	public void setNumberOfD(int newNumberOfD) {
		this._numberofD = newNumberOfD;
	}
	public int numberOfF() {
		return this._numberofF;
	}
	public void setNumberOfF(int newNumberOfF) {
		this._numberofF = newNumberOfF;
	}
	
	//Constructor
	public GradeCounter() {
		this.setNumberOfA(0);
		this.setNumberOfB(0);
		this.setNumberOfC(0);
		this.setNumberOfD(0);
		this.setNumberOfF(0);
	}
	
	//public method
	public void count(char aGrade) {
		switch(aGrade) {
		case 'A':
			this.setNumberOfA(this.numberOfA()+1);
			break;
		case 'B':
			this.setNumberOfB(this.numberOfB()+1);
			break;
		case 'C':
			this.setNumberOfC(this.numberOfC()+1);
			break;
		case 'D':
			this.setNumberOfD(this.numberOfD()+1);
			break;
		case 'F':
			this.setNumberOfF(this.numberOfF()+1);
			break;
		}
	}
	
}
