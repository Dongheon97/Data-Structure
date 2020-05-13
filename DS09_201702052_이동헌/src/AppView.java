import java.util.Scanner;

public class AppView {
	//비공개 상수, 변수들
	private static final Scanner scanner = new Scanner(System.in);
	private static boolean debugMode = false;
	
	//생성자
	public AppView() {
		
	}
	
	//공개 함수의 구현
	public static boolean debugMode() {
		return AppView.debugMode;
	}
	public static void setDebugMode(boolean newDebugMode) {
		AppView.debugMode = newDebugMode;
	}
	
	public static void outputDebugMessage(String aMessage) {
		if(AppView.debugMode()) {
			System.out.print(aMessage);
		}
	}
	
	public static void outputLineDebugMessage(String aMessage) {
		if(AppView.debugMode()) {
			System.out.println(aMessage);
		}
	}
	
	//출력을 위한 공개함수
	public static void output(String aMessage) {
		System.out.print(aMessage);
	}
	public static void outputLine(String aMessage) {
		System.out.println(aMessage);
	}
	
	//입력을 위한 공개함수
	public static String inputLine() {
		String line = AppView.scanner.nextLine().trim();
		while(line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line; 
	}
}
