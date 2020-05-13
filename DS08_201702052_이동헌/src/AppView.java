import java.util.Scanner;

public class AppView {

	//비공개 상수,변수들
	private static final Scanner scanner = new Scanner(System.in);
		
	//생성자
	public AppView() {}
	
	//공개함수의 구현
	
	//출력을 위한 공개함수
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void output(String message) {
		System.out.print(message);
	}
	
	//입력을 위한 공개함수
	public static char inputChar() {
		String line = AppView.scanner.nextLine().trim();
		while(line.equals("")) {	
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}
}
