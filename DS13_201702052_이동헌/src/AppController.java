
public class AppController {

	//private constant
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	private static final int VALID_MAX_STUDENTID_LENGTH = 9;
	
	//private instance variable
	private Ban _ban;
	private GradeCounter _gradeCounter;
	
	//Getter/Setter
	private Ban ban() {
		return this._ban;
	}
	private void setBan(Ban newBan) {
		this._ban = newBan;
	}
	
	private GradeCounter gradeCounter() {
		return this._gradeCounter;
	}
	private void setGradeCounter(GradeCounter newGradeCounter) {
		this._gradeCounter = newGradeCounter;
	}
	
	//Constructor
	public AppController() {
		
	}
	
	//private static methods
	private static boolean socreIsValid(int aScore) {
		return(aScore >= AppController.VALID_MIN_SCORE &&
				aScore <= AppController.VALID_MAX_SCORE);
	}
	private static boolean studentIDISValid(int length) {
		return ( (length <= AppController.VALID_MAX_STUDENTID_LENGTH) );
	}
	
	
	private static DictionaryElement<String, Student> inputStudent() {
	
			DictionaryElement<String, Student> element = new DictionaryElement<String, Student>();
			Student student = new Student();
			
			String studentID = AppView.inputStudentID();
			int score = AppView.inputScore();
			//점수와 학번을 입력받는다.
			
			while((!AppController.studentIDISValid(studentID.length()))) {
				AppView.outputLine("(오류) 학번의 길이가 너무 깁니다. 최대 " +AppController.VALID_MAX_STUDENTID_LENGTH+  " 입니다.");
				studentID = AppView.inputStudentID();
			}
			while(!AppController.socreIsValid(score)) {
				AppView.outputLine("(오류) " + AppController.VALID_MIN_SCORE + " 보다 작거나 "
				+ AppController.VALID_MAX_SCORE +" 보다 커서, 정상적인 점수가 아닙니다.");
				score = AppView.inputScore();
			}

			student.setStudentID(studentID);
			student.setScore(score);
			
			element.setObject(student);
			element.setKey(studentID);		//입력순으로 받기 위한 객체
			
			return element;
	}
	
	private void inputAndStoreStudents() {
		AppView.outputLine("");
		AppView.output("? 학생정보를 입력하려면 'Y' 또는 'y'를, 마치려면 다른 아무키나 치시오: ");
		
		int[] score = new int[100];
		String[] studentID = new String[100];
		int i=0;
		
		while (AppView.doesContinueToInputStudent()) {
			DictionaryElement<String, Student> element = AppController.inputStudent();
			this.ban().addKeyAndObject(element.key(), element.object());
			
	
			studentID[i] = element.key().toString();
			score[i] = element.object().score();
			i++;
			AppView.outputLine("");
			AppView.output("? 학생정보를 입력하려면 'Y' 또는 'y'를, 마치려면 다른 아무키나 치시오: ");
			
			
		}
		AppView.outputLine("! 성적 입력을 마칩니다.");
		this.showList(studentID, score, i);
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[학급 성적 처리 결과]");
		
		AppView.outputTotalNumberOfStudnet(this.ban().size());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage()); 
		//무한루프
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
	}
	
	
	private void showList(String[] studentID, int[] score, int aSize) {
		AppView.outputLine("");
		AppView.outputLine("[학생 목록]");
		for(int i =0; i<aSize; i++) {
			AppView.outputLine("학번: " +studentID[i]+ ", 점수: " + score[i] );
			
		}
	}
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[학점별 학생수]");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('f', this.gradeCounter().numberOfF());
	}
	
	
	private void showStudentsSortedBySocre() {
		AppView.outputLine("");
		AppView.outputLine("[학생들의 성적순 목록]");
		
		this.ban().studentsSortedByScore();
		
		Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator();
		Student student = null;
		while(iterator.hasNext()) {
			student = iterator.next().object();
			AppView.outputStudentInfo(student.studentID(), student.score(), this.ban().scoreToGrade(student.score()));
		}
	}
	
	//public methods
	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 시작합니다 >>>");
		this.setBan(new Ban());
		
		this.inputAndStoreStudents();
		
		
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(오류) 학생정보가 전혀 입력되지 않았습니다.");
		}
		else {
		
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedBySocre();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 종료합니다 >>>");
	}
}