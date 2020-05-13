
public class GradeCounter {
	//비공개 인스턴스 변수
	private int _numberOfA;
	private int _numberOfB;
	private int _numberOfC;
	private int _numberOfD;
	private int _numberOfF;
	
	//Getter/Setter
	public int numberOfA() {
		return this._numberOfA;
	}
	private void setNumberOfA(int newNumberOfA) {
		this._numberOfA = newNumberOfA;
	}
	public int numberOfB() {
		return this._numberOfB;
	}
	private void setNumberOfB(int newNumberOfB) {
		this._numberOfB = newNumberOfB;
	}
	public int numberOfC() {
		return this._numberOfC;
	}
	private void setNumberOfC(int newNumberOfC) {
		this._numberOfC = newNumberOfC;
	}
	public int numberOfD() {
		return this._numberOfD;
	}
	private void setNumberOfD(int newNumberOfD) {
		this._numberOfD = newNumberOfD;
	}
	public int numberOfF() {
		return this._numberOfF;
	}
	private void setNumberOfF(int newNumberOfF) {
		this._numberOfF = newNumberOfF;
	}
	
	//생성자
	public GradeCounter() {
		this.setNumberOfA(0);
		this.setNumberOfB(0);
		this.setNumberOfC(0);
		this.setNumberOfD(0);
		this.setNumberOfF(0);
	}
	
	//공개 함수
	public void count(char aGrade) {
		switch(aGrade) {
		case 'A' :
			this.setNumberOfA(this.numberOfA()+1);
			break;
		case 'B' :
			this.setNumberOfB(this.numberOfB()+1);
			break;
		case 'C' :
			this.setNumberOfC(this.numberOfC()+1);
			break;
		case 'D' :
			this.setNumberOfD(this.numberOfD()+1);
			break;
		case 'F' :
			this.setNumberOfF(this.numberOfF()+1);
			break;
		}
	}
	
}
