
public class Student {
	//����� ���,����
	private static final int DEFAULT_SCORE=0;
	private int _score;
	
	//Getter
	public int score() {
		return this._score;
	}
	//Setter
	public void setScore(int newScore) {
		this._score = newScore;
	}
	
	//������
	public Student() {
		this.setScore(DEFAULT_SCORE);
	}
		
	public Student(int givenScore) {
		this.setScore(givenScore);
	}
		
	@Override
	public boolean equals(Object aStudent) {
		if(aStudent.getClass() != Student.class) {
			return false;
		}
		else {
			return (this.score() == ((Student)aStudent).score());
		}
	}
}
