
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
			//������ �й��� �Է¹޴´�.
			
			while((!AppController.studentIDISValid(studentID.length()))) {
				AppView.outputLine("(����) �й��� ���̰� �ʹ� ��ϴ�. �ִ� " +AppController.VALID_MAX_STUDENTID_LENGTH+  " �Դϴ�.");
				studentID = AppView.inputStudentID();
			}
			while(!AppController.socreIsValid(score)) {
				AppView.outputLine("(����) " + AppController.VALID_MIN_SCORE + " ���� �۰ų� "
				+ AppController.VALID_MAX_SCORE +" ���� Ŀ��, �������� ������ �ƴմϴ�.");
				score = AppView.inputScore();
			}

			student.setStudentID(studentID);
			student.setScore(score);
			
			element.setObject(student);
			element.setKey(studentID);		//�Է¼����� �ޱ� ���� ��ü
			
			return element;
	}
	
	private void inputAndStoreStudents() {
		AppView.outputLine("");
		AppView.output("? �л������� �Է��Ϸ��� 'Y' �Ǵ� 'y'��, ��ġ���� �ٸ� �ƹ�Ű�� ġ�ÿ�: ");
		
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
			AppView.output("? �л������� �Է��Ϸ��� 'Y' �Ǵ� 'y'��, ��ġ���� �ٸ� �ƹ�Ű�� ġ�ÿ�: ");
			
			
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
		this.showList(studentID, score, i);
	}
	
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�б� ���� ó�� ���]");
		
		AppView.outputTotalNumberOfStudnet(this.ban().size());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage()); 
		//���ѷ���
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
	}
	
	
	private void showList(String[] studentID, int[] score, int aSize) {
		AppView.outputLine("");
		AppView.outputLine("[�л� ���]");
		for(int i =0; i<aSize; i++) {
			AppView.outputLine("�й�: " +studentID[i]+ ", ����: " + score[i] );
			
		}
	}
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[������ �л���]");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('f', this.gradeCounter().numberOfF());
	}
	
	
	private void showStudentsSortedBySocre() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���]");
		
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
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ� >>>");
		this.setBan(new Ban());
		
		this.inputAndStoreStudents();
		
		
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(����) �л������� ���� �Էµ��� �ʾҽ��ϴ�.");
		}
		else {
		
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedBySocre();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ� >>>");
	}
}