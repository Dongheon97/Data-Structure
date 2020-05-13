import java.util.Scanner;

public class AppView {
	//비공개 변수
	private static Scanner scanner = new Scanner(System.in);
		
	//생성자
	private AppView() {
		
	}
	
	//출력 관련 공개 함수
	/*public static void outputDebugMessage(String message) {
		System.out.print(message);
	}*/	
	public static void outputLine(String message) {
		System.out.println(message);
	}	
	public static void output(String message) {
		System.out.print(message);
	}
		
	//입력 관련 공개 함수
		
	public static int inputInteger() throws NumberFormatException{
		//정수가 아닌 경우의 에러처리를 보완할 것 : exception throws
		return Integer.parseInt(AppView.scanner.next());
	}
}
