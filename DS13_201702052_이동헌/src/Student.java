
public class Student implements Comparable<Student> {

	//private constant
	private static final int DEFAULT_SCORE = 0;
	
	//private instance variable
	private String _studentID;
	private int _score;
	private char _grade;
	
	//Getter / Setter
	public String studentID() {
		return this._studentID;
	}
	public void setStudentID(String newStudentID) {
		this._studentID = newStudentID;
	}
	public int score() {
		return this._score;
	}
	public void setScore(int newScore) {
		this._score = newScore;
	}
	public char grade() {
		return this._grade;
	}
	public void setGrade(char newGrade) {
		this._grade = newGrade;
	}
	
	public Student() {
		this.setScore(DEFAULT_SCORE);
		this.setStudentID(null);
	}
	public Student(String givenStudentID, int givenScore) {
		this.setScore(givenScore);
		this.setStudentID(givenStudentID);
	}
	
	@Override
	public int compareTo(Student aStudent) {
		if(this.score() < aStudent.score() ) {
			return -1;
		}
		else if(this.score() == aStudent.score()) {
			return 0;
		}
		else {
			return +1;
		}
	}
}
