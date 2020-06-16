import java.util.Scanner;
public class AppView {
	//private Constant
	private static final Scanner scanner = new Scanner(System.in);
	
	//Constructor
	private AppView(){
		
	}
	
	//public methods
	public static void output(String aMessage) {
		System.out.print(aMessage);
	}
	public static void outputLine(String aMessage) {
		System.out.println(aMessage);
	}
	
	public static void outputTotalNumberOfStudnet(int numberOfStudents) {
		AppView.outputLine("전체 학생 수: " + numberOfStudents);
	}
	public static void outputHighestScore(int aScore) {
		AppView.outputLine("학급 최고 점수: " + aScore);
	}
	public static void outputLowestScore(int aScore) {
		AppView.outputLine("학급 최져 점수: " + aScore);
	}
	public static void outputAverageScore(double average) {
		AppView.outputLine("학급 평균 점수: " + average);
	}
	public static void outputNumberOfStudentsAboveAverage(int numberOfStudents) {
		AppView.outputLine("평균 이상인 학생 수: " + numberOfStudents);
	}
	public static void outputNumberOfStudentsForGrade(char aGrade, int numberOfStudents) {
		AppView.outputLine(aGrade + " 학점은 모두 " + numberOfStudents + " 명 입니다.");
	}
	public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
		AppView.outputLine("학번: " + aStudentID + ", 점수: "+ aScore +", 학점: "+ aGrade);
	}
	
	public static int inputInt() throws NumberFormatException{
		return Integer.parseInt(AppView.scanner.next());
	}
	
	public static boolean doesContinueToInputStudent() {
		String inputString = AppView.scanner.next();
		if(inputString.charAt(0) == 'Y' || inputString.charAt(0)=='y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String inputStudentID(){
		AppView.output("- 학번을 입력하시오: ");
		String inputString = AppView.scanner.nextLine();
		while(inputString.equals("")) {
			inputString = AppView.scanner.nextLine();
		}
		return inputString;
	}
	
	public static int inputScore() {
		AppView.output("- 점수를 입력하시오: ");
		int inputScore = AppView.scanner.nextInt();
		return inputScore;
	}
}
