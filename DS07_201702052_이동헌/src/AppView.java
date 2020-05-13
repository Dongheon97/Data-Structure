import java.util.Scanner;

public class AppView {
	//비공개 상수/변수들
	private static Scanner scanner = new Scanner(System.in);

	public AppView() {
	}
	
	//입력을 위한 공개함수
	public static int inputInt() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	public static int inputScore() {
		while (true) {
			try {
				AppView.output("- 점수를 입력하시오 (0..100): ");
				int score = AppView.inputInt();
				return score;
			}
			catch(NumberFormatException e){
				AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
			}
		}
	}
	
	//출력을 위한 공개함수
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void output(String message) {
		System.out.print(message);
	}
	
	//학급 학생 수 출력
	public static void outputNumberOfStudents(int aNumberOfStudents) {
		AppView.outputLine("학급 학생 수: " + aNumberOfStudents );
	}
	
	//학급 최고 점수 출력
	public static void outputHighestScore(int aScore) {
		AppView.outputLine("학급 최고 점수: " + aScore );
	}
	
	//학급 최저 점수 출력
	public static void outputLowestScore(int aScore) {
		AppView.outputLine("학급 최저 점수: " + aScore );
	}
	
	//평균값을 출력
	public static void outputAverageScore(double anAverageScore) {
		AppView.outputLine("학급 평균: " + anAverageScore );
	}
	
	//평균 이상인 학생 수 출력
	public static void outputNumberOfStudentsAboveAverage(int anNumberOfStudents) {
		AppView.outputLine("평균 이상인 학생 수: " + anNumberOfStudents );
	}
	
	//각 학점에 대한 학생 수 출력
	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) {
		AppView.outputLine(aGrade + " 학점의 학생 수는 " + aNumberOfStudents + " 입니다.");
	}
	
	//학생들의 점수 출력
	public static void outputScore(int aScore) {
		AppView.outputLine("점수: " + aScore);
	}
	
	public static boolean doesContinueToInputStudent() {
		AppView.output("성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 치시오: ");
		String line = null;
		do {
			line = AppView.scanner.nextLine();
		}while(line.equals(""));
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y'));
	}
}
