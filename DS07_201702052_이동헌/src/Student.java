
public class Student implements Comparable<Student> {
	//비공개 상수/변수
	private static final int DEFAULT_SCORE = 0;
	
	private int _score; //점수
	
	//Getter/Setter
	public int score() {
		return this._score;
	}
	public void setScore(int newScore) {
		this._score = newScore;
	}
	
	//생성자
	public Student() {
		this.setScore(DEFAULT_SCORE);
	}
	public Student(int givenScore) {
		this.setScore(givenScore);
	}
	
	public interface Comparable<E>{
		public int compareTo(Student other);
	}
	
	@Override
	public int compareTo(Student other) {
		if(this.score() < other.score()) {
			return -1;
		}
		else if(this.score() == other.score()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
