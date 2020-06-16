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
		AppView.outputLine("��ü �л� ��: " + numberOfStudents);
	}
	public static void outputHighestScore(int aScore) {
		AppView.outputLine("�б� �ְ� ����: " + aScore);
	}
	public static void outputLowestScore(int aScore) {
		AppView.outputLine("�б� ���� ����: " + aScore);
	}
	public static void outputAverageScore(double average) {
		AppView.outputLine("�б� ��� ����: " + average);
	}
	public static void outputNumberOfStudentsAboveAverage(int numberOfStudents) {
		AppView.outputLine("��� �̻��� �л� ��: " + numberOfStudents);
	}
	public static void outputNumberOfStudentsForGrade(char aGrade, int numberOfStudents) {
		AppView.outputLine(aGrade + " ������ ��� " + numberOfStudents + " �� �Դϴ�.");
	}
	public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
		AppView.outputLine("�й�: " + aStudentID + ", ����: "+ aScore +", ����: "+ aGrade);
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
		AppView.output("- �й��� �Է��Ͻÿ�: ");
		String inputString = AppView.scanner.nextLine();
		while(inputString.equals("")) {
			inputString = AppView.scanner.nextLine();
		}
		return inputString;
	}
	
	public static int inputScore() {
		AppView.output("- ������ �Է��Ͻÿ�: ");
		int inputScore = AppView.scanner.nextInt();
		return inputScore;
	}
}
